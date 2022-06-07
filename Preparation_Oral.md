---
Author: Ethan Arm
---

# Préparation Orale - Conceptes et Langages Orientés Objets

Ce document est destinée a servire de repère dans les révisions des sujets d'examen du cours *Concepts et Langages Orientés Objets - CLOO*.

Chaque thème requis a l'examen est abordée de manière seule puis ouvert vers la généralité du cours.

## Enumérations

---

### Définition d'énumération

Une énumération est un ensemble prédéfini de constantes. Par exemple:

- mois dans l'année: janvier, février,...
- état d'une porte: ouvert, fermé, vérouillé
- couleurs aux échecs
- couleurs de cartes
- ...

Selon les langages ses constantes sont représenté par le système de différentes manières, en *C* par exemple ses constantes sont enfait des entiers, cela peut nôtament causer des erreurs de nomage, alors qu'en *java* il s'agit d'un type a part entière.

Les énumérations sont particulièrement utiles pour tester des égalités prédéfinit ou des états. Elles sont généralement utilisées en combinaisons avec des `switch case` puisqu'elles possèdent des valeurs fixe.

### Exemple d'énumération en *java*

Déclaration d'une énumération:

```java
public enum DoorState {
    OPEN, CLOSED, LOCKED
}
```

Utilisation d'une énumération:

```java
import static DoorState.*;

DoorState open( DoorState current ) {
    if( current == CLOSED )
        return OPEN;
    else if( current == LOCKED )
        throw new IllegalStateException("Cannot open a locked door");
    else throw new IllegaleStateException("Door is already open !");
}
```

Utilisation en combinaison avec un `switch case`:

```java
import static DoorState.*;

DoorState open( DoorState current ) {
    switch(current) {
        case CLOSED:
            return OPEN;
        case LOCKED:
            throw new IllegalStateException("Cannot open a locked door");
        case OPEN:
            throw new IllegaleStateException("Door is already open !");
    }
}
```

---

## Généricité et varience

## Héritage et aggrégation

## Héritage et Polymorphisme

## Héritage: redéfinition des méthodes

## Identité et Egalité

## Lambda Expressions

---

En *java*, il existe plusieurs objets annonymes, les *Lambda Expressions* et les *Classes Annonymes*.

Les *lambdas expressions* sont un concepte commun de l'orienté objet qui repose en vérité sur une approche plus fonctionnelle de programmation. Contrairement aux *Classes Annonymes* qui sont un spécifique *java*.

### Classes Annonymes

Les *classes Annonymes* sont comme leurs noms l'indique des *classes*, celles-ci sont définie autour d'une interface. C'est-à-dire qu'il existe une *interface* qui définie les méthode nécessaire et la classe annonymes définie leur implémentation. Par exemple:

```java
public interface Armure {
    public int absorb(int dmg);
}

public class Main {

    public static void main(String[] args){
        Armure chain_mail = new Armure() {
            public int absorb(int dmg){
                int ndmg = dmg-15;
                if (ndmg>0) {return ndmg;}
                return 0;
            }
        };

        var leather_arm = new Armure(){
            public int absorb(int dmg){
                if (dmg-1 > 0) {return dmg-1;}
                return 0;
            }
        };
    }
}
```

On peut voir ici que `chain_mail` et `leather_arm` sont deux *classes annonymes* différentes qui représentes deux implémentations possible de l'*interface* `Armure`.

### Expressions Lambdas

Les *Expressions Lambdas* est un concepte nommé en référence au *Lambda calcul*, il s'agit d'un concept récurrent de l'orienté objets, on le voit nôtament en *python*, *java* ou encore *swift*.

Le principe est simple, il s'agit d'une fonction non nommé qui peut-être passé en paramètre ou encore retouné par une autre fonction.
Par exemple en *java*:

```java
(int a, int b) -> {a+b}; //ou encore:
(a,b) -> a+b;
```

Ou en *python*:

```python
lambda a,b: a+b
```

### Lambda Expressions VS Classes Anonymes

En *java* une *expression lambda* peut aussi être combiné avec une *interface* du façon similaire à une *classe annonyme*, à condition que cette *interface* ne possède qu'une unique fonction. Par exemple, si on reprend l'*interface* `Armure` précédente:

```java
Armure chain_mail = (int dmg) -> {
    if (dmg > 15) {return dmg-15;}
    return 0;
};
```

Il est important de noter que à l'inverse d'une *classe annonyme*, le type d'une *lambda expression* ne peut-être inférer le type de retour, elles ne sont pas utilisable avec le mot-clef `var`.

De plus, sûr un grand nombre d'opération les *lambda expressions* se révèle beaucoup moins coûteuse en temps de calcul et mémoire aue leur contre-partir classé.

### Extensions des Lambda Expression et Classes Annonymes

Ces deux concepts se mélange particulièrement bien avec le concept de généricité avec des types générique. Par exemple, en *java* dans le cas d'un générateur de valeur aléatoire:

```java
import java.util.Random;

public interface RandomGenerator<T>{
    public T single(Random rng);
}

public class Main {
    public static RandomGenerator<HealingPotion> anonymous_healingPotionRG(HealingPotion hp)  {
        return new RandomGenerator<>() {
            public HealingPotion single(Random rng){
                return hp.genItem(rng);
            }
        };
    }
    public static RandomGenerator<HealingPotion> lambda_healingPotionRG(HealingPotion hp){
        return (Random rng) -> {return hp.genItem(rng);};
    }

    public static void main(String[] args){
        HealingPotion potionAnonyme = anonymous_healingPotionRG(new HealingPotion()).single(gameRNG);

        HealingPotion potionLambda = lambda_healingPotionRG(new HealingPotion()).single(gameRNG);
    }
}
```

Les deux fonctions font exactement la même chose, elles génèrent toute les deux un objet de l'interface demander. Mais on peut tou de suite voir que la version avec une *lambda expression* est beaucoup plus légère et compréhensible que sa contrepartie.

De plus, le mélange avec les *types générique* est particulièrement facile.

Un autre point particulièrement utils des *lambda expressions* en *java* est que celles-ci se conforme aux *interfaces* demandé en paramètres pour différentes tels que les *stream* par exemple la méthode `map` d'un *stream* prend en paramètre une fonction ou la méthode `filter` prend en paramètre un *prédicat*.

---

## Mutabilité et immutabilité

## Polymorphisme et interfaces

## Principe de substitution de Liskov

## Références et construction

## Références et passage d'argument

## Références, méthodes et mutabilité

## Visibilité et Contrôle d'accès

---

### Principe et mots-clefs de la visibilité et du Contrôle d'accès

La visibilité est une propriété contextuel, c'est-à-dire qu'elle est dépendante de l'endroit ou on se trouve.
Il est possible de voir un certain attribut à un endroit mais pas a un autre.

Le contrôle d'accès est une notion fortement liée à la visibilité puisqu'un attribut qui ne peut être vu ne peut être directement accéder par un utilisateur.

Il existe différents mots-clefs liés à la visibilité et à l'accès en orienté objet, plus spécifiquement en *java*:

- `public`
- `protected`
- `private`
- `default`

Ces mot-clefs sont contexte dépendant, dans le cas d'un attribut de class (méthode, constructeur, données):

- Un atttibut `public` peut-être vu et manipulé depuis l'extérieur de la class depuis n'importe quel contexte.
- Un attribut `protected` ne peut-être vu et manipulé qu'à l'intérieur du package dans lequel est défini sa classe, à l'exception d'une sous-classe de la classe de l'attribut.
- Un attribut `private` ne peut-être vu et manipulé uniquement depuis l'intérieur de sa classe.
- un attribut spécifié `default` revient à la même chose que de ne pas mettre de mots-clef d'accès. Le comportement est alors le même que `protected`.

Dans le cas d'une classe et d'une interface:

- Une classe `public` peut-être vu et manipulé depuis n'importe quel context d'où elle as été préaleblement défini ou importer.
- Une classe ne peut avoir l'attribut `protected` à l'execption d'une classe déclàré dans une classe.
- Une classe `private` ne peut-être vu et manipulé uniquement a l'intérieur du contexte où elle as été définie.
- Une classe spécifié `default` a le même comportement que si aucun mot-clefs d'accès est défini. Dans ce cas, la classe ne peut-être accéder que depuis le package où elle as été déclarée.

Dans certain cas il est généralement désirable qu'un utilisateurs ne puisse directement accéder à certains attribut d'une classe, afin de cacher l'implémentation et la rendre plus abstraite.
Dans ce cas, on peut spécifié l'attribut comme *privé*, `private`, et on définie certaines méthodes pour y accéder et si besoin le modifié.
Ces méthodes d'accès sont appellées *getter*, en français *accesseur*, et les méthodes de modifications sont appellées *setter*, en français *modifieur*.

En général, il est désirable que ces *getter* et *setter* retournent des *intefaces* pour cacher les détails d'implémentation, par exemple si l'on décide de changer le type de retour d'un *getter*. Si on change d'un `int` à un `long`, ci on récupère souvent la valeur on peut se retrouver a devoir changer plusieurs centaines lignes de code pour peut de choses. Alors que si, par defaut, ils retournaient une *interface*, il suffirait de modifier certaines méthode de la dites *interface*.

Les contraintes liés aux *accesseurs* restent des problème de design de système, c'est-à-dire que si on écrit une API qui va être utilisé de manière inconnu il est normal de mettre beaucpoup d'accesseurs, mais si on écrit quelque choses de très spécifique et que l'on sait exactement de quel manière on vas l'utilisé il ne fait aucun sens de définir des accesseur a tord et à travers.
