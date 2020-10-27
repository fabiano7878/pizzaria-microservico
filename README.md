# pizzaria-microservico usando Spring Boot
Tento simular uma pizzaria nacional, onde a loja pode disparar pedidos a forncedores de outros estados, conforme escolha do cliente, também estudo
como trabalhar no ambiente de microserviço e um dos metodos de configurar a comunicação entre eles e gerenciamento de acessos.

obs.: o diretório "\pizzaria-microservico\microservice-repo\fornecedor.yml" está presente, caso queira usar a configuração de banco de dados no ambiente que esta o micro serviço e não no github como foi feito na parte final com a evoluação do preojto.


# restTemplate
Para ustilização de comnuição de protocolo http de alto nivel, comunicação REST

# Spring Feign
Aprimorando a aplicação, ele fornece designe aprimorado através de interface para realizarmos as chamadas dos microserviçõs externos e também tem a impleemntação do Ribbon que fornece o load balance.
Nos ajuda a criar chamdas via REST para outro microserviço.


# Eureka
Eureka tem a habilidade de fazer os microsserviços se comunicarem entre si, tanto para se disponibilizarem como serviço como para descobrir instâncias de outros microsserviços.

Uma introdução ao Service discovery e Service registry
- Service registry é um servidor central, onde todos os microsserviços ficam cadastrados (nome e IP/porta)
- Service discovery é um mecanismo de descoberta do IP do microsserviço pelo nome. Dessa forma, nenhum microsserviço fica acoplado ao outro pelo IP/porta
a resolução do IP/porta é através do nome do microsserviço nas requisições.
Com o 
Service Discovery eu faço o Gerenciamento dos acessos dos microserviços, resolução de dominios, também defino as informações de como cada microserviço encontra o destino de sua requisição em outro microserviço pela rede.

# SpringConfig
Spring Config Server é uma implementação do servidor do projeto Spring Cloud
Coinfigurei este serviço como centralizador das configurações de base, ele vai fornceer incialmente toda configuração externa para os microservições de
forma centralizada. 
Como boa prátivca de reutilização, centralizei so acessos a base de dados e externalizei em repo do git a configuração especifica de cada microserviço fornecedor.
Fica fácil disponibilizar os recursos para todos os microserviços e quem gerencia isso muito bem é o Spring config.

# repository
Usei o conceito de repositórie para configuração das instancias que comunicam com a base de dados no Java, e a configuração dessas fica no Config server e acessada pela biblioteca Scpring client, que le um repository criado no github.

# Log4J - logback
Usei a implementação para gerar os logs e fazer a rastreabilidade dos microserviços

# Spring Sleuth
Facilita para organizar as chamadas dos logs, gerando um id facilitando a rastreabilidade dos registros, configurando no logback.

# Papertrail
Usei a configuração junto com a do log4j, no logback, para enviar para o parpertrail os logs gerados e unificar em um lugar só e online.


# Hystrix
Usei o Hystrix habilitando o circuit braker, caso haja falha no processo de requisição de compra.
Com Hystrix também é possivel fazer as chamadas para os metodos de Fallback, neste caso o metodo implementado é o "realizaCompraFallBack."


# Bulkhead de theads com o Hystrix
Neste exemplo entendo como funciona o compartilhamento de theads, o Hystrix consegue liberar 10 threads para cada
funcionalida, no caso na classe "compraService" temos a funcionalidade de findByIB e "realizaComrpa", e as threads foram compartilhadas adequadamente.



# zuul (API Gateway)
É a API Gateway, tem à habilidade de acessar o Eureka e descobrir quais microserviçoes estão disponiveis para acessar.



# Spring Security e Spring Cloud OAuth2 + Feign
Usei o 2 para para criar o microserviço de Autenticação entre, as requisições do cliente, tanto no scopo web ou mobile, integrando os 2, expondo os recusos do Spring Security AuthenticationManager e UserDetailServiceconsigo  injetaar os Adapter do Spring Cloud OAuth2: o AuthorizationServerConfigurerAdapter. Mais especificamente, a integração é feita no método configure deste adapter.

Colocamos um usuários para acesso do auntenticador que nos gera um token, que irá trafegar pelos microserviçõs e usar-lo para conseguir ois dados do cliente.

Usamos o Feign para nos ajudar a tramitar os dados do header, pois as threads foram gerenciadas pelo Hystrix e não compartilham conteudo, fizemos o Hystrix compartilhar os dados e passar os dados de Authorization para o então o Feign conseguir atrvés da interface RequestInterceptor ter os dados de Authenticação.
