package com.redhat.service.smartevents.manager.core.services;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import com.redhat.service.smartevents.manager.core.TestConstants;
import com.redhat.service.smartevents.manager.core.persistence.dao.ShardDAO;
import com.redhat.service.smartevents.manager.core.persistence.models.Shard;
import com.redhat.service.smartevents.manager.core.utils.DatabaseManagerUtils;
import com.redhat.service.smartevents.test.resource.PostgresResource;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
// This annotation also bootstraps Quarkus into using DevServices for ALL @QuarkusTest's
@QuarkusTestResource(value = PostgresResource.class)
public class ShardServiceTest {

    @Inject
    ShardDAO shardDAO;

    @Inject
    ShardService shardService;

    @Inject
    DatabaseManagerUtils databaseManagerUtils;

    @Test
    public void testGetAssignedShard() {
        databaseManagerUtils.cleanUp();
        Shard shard = new Shard();
        shard.setRouterCanonicalHostname(TestConstants.DEFAULT_SHARD_ROUTER_CANONICAL_HOSTNAME);
        shardDAO.persist(shard);

        Shard retrieved = shardService.getAssignedShard("myId");

        assertThat(retrieved.getId()).isEqualTo(shard.getId());
        assertThat(retrieved.getRouterCanonicalHostname()).isEqualTo(TestConstants.DEFAULT_SHARD_ROUTER_CANONICAL_HOSTNAME);
    }

    @Test
    public void testGetDefaultAssignedShardId() {
        databaseManagerUtils.cleanUpAndInitWithDefaultShard();

        Shard shard = shardService.getAssignedShard("myId");

        assertThat(shard.getId()).isEqualTo(TestConstants.SHARD_ID);
        assertThat(shard.getRouterCanonicalHostname()).isEqualTo(TestConstants.DEFAULT_SHARD_ROUTER_CANONICAL_HOSTNAME);
    }

    @Test
    public void testUpdateShardCanonicalHostnameIfNotAligned() {
        databaseManagerUtils.cleanUp();
        Shard shard = new Shard();
        shard.setRouterCanonicalHostname("unalignedcanonicalhostname.com");
        shardDAO.persist(shard);

        ((ShardServiceImpl) shardService).init();

        Shard retrieved = shardService.getAssignedShard("myId");

        assertThat(retrieved.getRouterCanonicalHostname()).isEqualTo(TestConstants.DEFAULT_SHARD_ROUTER_CANONICAL_HOSTNAME);
    }
}
