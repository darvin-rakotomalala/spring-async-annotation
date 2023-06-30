## Spring Boot - @Async annotation

Dans ce repo, nous verrons quelques exemples appels **asynchrones** dans Spring Boot à l'aide de l'annotation `@Async` avec
`CompletableFuture`. En termes simples, annoter une méthode d'un bean avec @Async la fera s'exécuter dans un thread
séparé. En d'autres termes,
l'appelant n'attendra pas la fin de la méthode appelée.

**Voyons la différence entre synchrone et asynchrone**

- **Programmation synchrone** :  Dans la programmation synchrone, les tâches sont exécutées une à la fois et seulement
  lorsque l'une est terminée, la suivante est débloquée.

- **Programmation asynchrone** :  Dans la programmation asynchrone, plusieurs tâches peuvent être exécutées
  simultanément.
  Vous pouvez passer à une autre tâche avant la fin de la précédente.

Spring fournit une fonctionnalité pour exécuter un processus de longue durée dans un thread séparé.  
Cette fonctionnalité est utile lors de la mise à l'échelle des services. En utilisant les annotations `@Async`
et `@EnableAsync`,
nous pouvons exécuter les travaux coûteux en arrière-plan et attendre les résultats en utilisant
l'interface `CompletableFuture` de Java.

Il y a quelques règles dont nous devrions nous souvenir lors de l'utilisation de cette annotation.

- L'annotation `@Async` doit être sur la méthode publique . Spring utilise un proxy pour cette annotation et il doit
  être public pour que le proxy fonctionne - Méthodes avec le type de retour vide
- Appel de la méthode async depuis la même classe. Cela ne fonctionnera pas (l'appel de méthode comme celui-ci
  contournera le proxy).
- La méthode avec un type de retour doit être `CompletableFuture` ou `Future`.
- Pour combiner le résultat de plusieurs tâches asynchrones, utilisez la méthode join().
  Ex : `CompletableFuture.allOf(methodOne, methodTwo, methodThree).join();`