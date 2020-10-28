# NanoAutoClicker

É um sistema de autoclick para o seu servidor, que tem como função atacar mobs de forma automática.

## Comandos

• `/autoclick` - Sem permissão <br>
• `/autoclick add <player>` - autoclick.admin <br>
• `/autoclick remove <player>` - autoclick.admin

## Configuração

```yml
#Comandos
#
# • /autoclick - Não precisa de permissão
# • /autoclick add <player> - autoclick.admin
# • /autoclick remove <player> - autoclick.admin
#
# nanoplugins.com | nanoplugins.com.br | nanoplugins.fun

#Definições
settings:
  time: 10 #Segundos
  damage: 5 #Dano que dá no mob
  range:
    x: 3 #Blocos do x
    y: 0 #Blocos do y
    z: 3 #Blocos do z

#Mensagens
messages:
  player-not-found: "&cPlayer não encontrado!" #Player não encontrado
  no-perm: "&cSem permissão!" #Sem permissão
  deactivate: "&cVocê desativou o autoclick!" #Desativar
  activate: "&aVocê ativou o autoclick!" #Ativar
  add:
    need-args: "&c/autoclick add <player>" #Comando incorreto
    sender: "&aAtivaste o autoclick do player &f%player%&a!" #Adicionar quem executou
    target: "&aAtivaram o autoclick para você!" #Quem recebeu
  remove:
    need-args: "&c/autoclick remove <player>" #Comando incorreto
    sender: "&aDesativaste o autoclick do player &f%player%&a!" #Quem executou
    target: "&cDesativaram o seu autoclick!" #Quem recebeu
```

## API

**Pegar a api**
```java
NanoAutoClickerAPI api = new NanoAutoClickerAPI().get();
System.out.println("Numero de players com autoclick: " + api.getUsers().size());
```

**Evento quando hita uma entidade** <br>
`AutoClickHitEvent`
```java
@EventHandler  
public void onCall(AutoClickHitEvent event) {  
  System.out.println("Player: " + event.getPlayer());  
  System.out.println("Entidade: " + event.getLivingEntity());
  System.out.println("Vida: " + event.getHealth());
  System.out.println("Vida depois de levar hit: " + event.getAfterDamagedHealth()); 
}
```
