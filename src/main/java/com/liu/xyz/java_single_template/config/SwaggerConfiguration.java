package com.liu.xyz.java_single_template.config;

import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfiguration
 * <p>配置可放在功能模块通过配置文件动态配置减少代码量</p>
 * <p>@EnableSwagger2WebMvc注解适用于webmvc，需要webflux使用@EnableSwagger2WebFlux</p>
 * @author jmac
 * @since 2022-08-28
 */
@Configuration
public class SwaggerConfiguration {




   // private final OpenApiExtensionResolver openApiExtensionResolver;


//    public SwaggerConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
//        this.openApiExtensionResolver = openApiExtensionResolver;
//    }

//    @Bean
//    public OpenApiExtensionResolver openApiExtensionResolver(){
//
//        return  new OpenApiExtensionResolver();
//    }
//
//    @Bean
//    @Order(value = 1)
//    public Docket docDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
////               .pathMapping("/doc")//路径匹配器 配置gateway的匹配路径一样
//                .enable(true)
//                .apiInfo(groupApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build()
//             //   .extensions(openApiExtensionResolver.buildExtensions("knife4j-doc"))
//                ;
//    }
//
//    private ApiInfo groupApiInfo(){
//        return new ApiInfoBuilder()
//                .title("my 文档")
//                .description("测试专用")
//                .termsOfServiceUrl("localhost:2000")
//                .contact(new Contact("jmac",
//                        "https://www.gfwlest.com",
//                        "hhwzyan@163.com"))
//                .version("1.0.0")
//                .build();
//    }
//
//    /**
//     * 增加如下配置可解决Spring Boot 6.x 与Swagger 3.0.0 不兼容问题
//     **/
//    @Bean
//    public WebMvcEndpointHandlerMapping webEndpointServletHandlerMapping(WebEndpointsSupplier webEndpointsSupplier,
//                                                                         ServletEndpointsSupplier servletEndpointsSupplier,
//                                                                         ControllerEndpointsSupplier controllerEndpointsSupplier,
//                                                                         EndpointMediaTypes endpointMediaTypes,
//                                                                         CorsEndpointProperties corsProperties,
//                                                                         WebEndpointProperties webEndpointProperties,
//                                                                         Environment environment) {
//        List<ExposableEndpoint<?>> allEndpoints = new ArrayList<>();
//        Collection<ExposableWebEndpoint> webEndpoints = webEndpointsSupplier.getEndpoints();
//        allEndpoints.addAll(webEndpoints);
//        allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
//        allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
//        String basePath = webEndpointProperties.getBasePath();
//        EndpointMapping endpointMapping = new EndpointMapping(basePath);
//        boolean shouldRegisterLinksMapping = this.shouldRegisterLinksMapping(webEndpointProperties, environment, basePath);
//        WebMvcEndpointHandlerMapping webMvcEndpointHandlerMapping = new WebMvcEndpointHandlerMapping(endpointMapping, webEndpoints, endpointMediaTypes, corsProperties.toCorsConfiguration(), new EndpointLinksResolver(allEndpoints, basePath), shouldRegisterLinksMapping, null);
//        return webMvcEndpointHandlerMapping;
//    }
//    private boolean shouldRegisterLinksMapping(WebEndpointProperties webEndpointProperties, Environment environment, String basePath) {
//        return webEndpointProperties.getDiscovery().isEnabled() && (StringUtils.hasText(basePath) || ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
//    }

}
