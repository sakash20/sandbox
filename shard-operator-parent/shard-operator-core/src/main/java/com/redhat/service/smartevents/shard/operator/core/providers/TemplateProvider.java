package com.redhat.service.smartevents.shard.operator.core.providers;

import com.redhat.service.smartevents.shard.operator.core.resources.istio.authorizationpolicy.AuthorizationPolicy;
import com.redhat.service.smartevents.shard.operator.core.resources.istio.gateway.Gateway;
import com.redhat.service.smartevents.shard.operator.core.resources.istio.requestauthentication.RequestAuthentication;
import com.redhat.service.smartevents.shard.operator.core.resources.istio.virtualservice.VirtualService;
import com.redhat.service.smartevents.shard.operator.core.resources.knative.KnativeBroker;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.networking.v1.Ingress;
import io.fabric8.openshift.api.model.Route;

public interface TemplateProvider {
    Secret loadBridgeIngressSecretTemplate(HasMetadata resource, TemplateImportConfig config);

    ConfigMap loadBridgeIngressConfigMapTemplate(HasMetadata resource, TemplateImportConfig config);

    KnativeBroker loadBridgeIngressBrokerTemplate(HasMetadata resource, TemplateImportConfig config);

    AuthorizationPolicy loadBridgeIngressAuthorizationPolicyTemplate(HasMetadata resource, TemplateImportConfig config);

    Route loadBridgeIngressOpenshiftRouteTemplate(HasMetadata resource, TemplateImportConfig config);

    Ingress loadBridgeIngressKubernetesIngressTemplate(HasMetadata resource, TemplateImportConfig config);

    Secret loadObservabilitySecretTemplate(String name, String namespace);

    Gateway loadIstioGatewayTemplate();

    VirtualService loadIstioVirtualServiceTemplate();

    RequestAuthentication loadJWTRequestAuthenticationTemplate();

    void updateMetadata(HasMetadata resource, ObjectMeta meta, TemplateImportConfig config);
}