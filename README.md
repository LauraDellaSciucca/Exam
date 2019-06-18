# PROGRAMMAZIONE A OGGETTI

Nel repository è presente lo svolgimento del progetto dell'esame di programmazione a oggetti.

## Progetto
### Descrizione 

Il dataset analizzato nel programma riguarda le attività commerciali di media e grande distribuzione della città di Milano.

A partire dall'indirizzo del dataset, il programma prevede il download del file in formato JSON. Attraverso una decodifica di tale file si ottiene la URL utile per scaricare il file in formato CSV.

Successivamente viene effettuato il parsing del file CSV che permette di creare la struttura e le funzionalità della classe `Business.java.`

Infine l'utente può effettuare delle richieste sul dataset per visualizzare i dati e metadati in formato JSON e statistiche relative a numeri e stringhe. L'utente può inoltre, in fase di richiesta, inserire filtri con operatori logici e condizionali.


### Specifiche tecniche

Il programma è stato sviluppato in Java tramite l'utilizzo del software Eclipse e del framework Spring.

E' stato utilizzato Postman per valutare il corretto funzionamento del programma. Altri software utilizzati sono stati Maven, Brackets e Github.


## Struttura del progetto 

### Package

Il progetto è strutturato in 5 package:

- **javaExamProject.spring:** al cui interno troviamo la classe `javaExamProjectApp.java` contenente il main che permette l'avvio del programma.
- **javaExamProject.spring.controller:** caratterizzato dalla classe che rappresenta il componente con il quale interagisce direttamente l'utente. 
- **javaExamProject.spring.model:** costituito dalla classe `Business.java` e `Metadata.java` che permette di visualizzare i metadati relativi agli attributi del dataset.
- **javaExamProject.spring.service:** costituita da 4 classi
  - `BusinessService.java:` interfaccia
  - `BusinessServiceImplements.java:` classe che implementa l'interfaccia
  - `ParserJSON.java:` in cui si effettua il parser del file JSON con il quale si trova il file in formato CSV e si effettua il relativo downolad
  - `ParserCSV.java:` classe utilizzata per effettuare il parser del file in formato CSV

- **javaExamProject.spring.util:** che contiene una classe utilizzata per la gestione degli errori.

### File

Nell'applicazione sono inotre presenti diversi file:

 - `pom.xml:` ha il compito di definire identità e struttura del progetto ed è utilizzato da Maven per reperire le dipendenze del progetto.
 - `appication.yml:` utilizzato per definire la porta e il percorso dell'applicazione
 - `UML:`per una visione generale del progetto e una migliore comprensione dei collegamenti tra classi. Di seguito il relativo diagramma.
 


![diagrammaUML](https://github.com/LauraDellaSciucca/Exam/blob/master/UML.png)

[link UML](https://github.com/LauraDellaSciucca/Exam/blob/master/UML.png)




## Autori 
 - D'Antonio Angela: (https://github.com/dantonioangela) 
 - Della Sciucca Laura: (https://github.com/LauraDellaSciucca) 


