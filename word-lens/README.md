<hr></hr>

# Word Lens

## Sobre

Aplicação Java EE para análise de frases, utilizando JSF, CDI, JPA, JMS e PrimeFaces.  
O deploy é feito no WildFly 10+.

---

## Configuração do Ambiente

### 1. Definindo variáveis de ambiente

Adicione ao final do seu `~/.bashrc` (Linux/macOS):

```bash
export WILDFLY_HOME=/caminho/para/seu/wildfly
```

Substitua `/caminho/para/seu/wildfly` pelo caminho real do seu WildFly.

Após editar, execute:

```bash
source ~/.bashrc
```

Se o comando `$WILDFLY_HOME` não funcionar, verifique se o `source` foi executado corretamente.

---

### 2. Configuração do WildFly

#### Fila JMS

No arquivo `standalone.xml`, adicione o subsistema JMS:

```xml
<subsystem xmlns="urn:jboss:domain:messaging-activemq:1.0">
    <server name="default">
        <jms-queue name="FraseQueue" entries="java:/jms/queue/FraseQueue"/>
    </server>
</subsystem>
```

#### Extensões

Adicione a extensão do JMS:

```xml
<extension module="org.wildfly.extension.messaging-activemq"/>
```

---

### 3. Datasource JDBC

#### Criando o datasource ExampleDS

1. Acesse o console do WildFly: http://localhost:9990  
   (Usuário e senha padrão: `admin`/`admin`)

2. Vá em **Configuration > Subsystems > Datasources**.

3. Clique em **Add** e escolha JDBC Datasource.

4. Nome: `ExampleDS`  
   JNDI: `java:jboss/datasources/ExampleDS`

5. Escolha o driver (ex: H2 para testes, ou outro de sua preferência).

6. Configure a URL, usuário e senha do banco.  
   Exemplo para H2:
   - URL: `jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`
   - Usuário: `sa`
   - Senha: *(em branco)*

7. Teste a conexão e salve.

---

### 4. Build e Deploy

Para compilar e implantar a aplicação no WildFly, execute:

```bash
mvn clean package && cp target/word-lens.war $WILDFLY_HOME/standalone/deployments/
```

Esse comando irá:

- Compilar o projeto e gerar o arquivo `.war`
- Copiar o `.war` para a pasta de deploy do WildFly, substituindo a versão anterior

Após copiar, o WildFly fará o deploy automaticamente.  
Para atualizar a aplicação, basta repetir o comando acima.

---

### 5. Observações

- Os avisos sobre `module-info.class` podem ser ignorados.
- Se alterar variáveis de ambiente, sempre execute `source ~/.bashrc`.
- Para rodar do zero:
  - Instale o WildFly
  - Configure o datasource e JMS conforme acima
  - Compile e faça o deploy com o comando único

<hr></hr>
