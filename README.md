# PROGRAMMAZIONE A OGGETTI

Nel repository è presente lo svolgimento del progetto relativo all'esame di **Programmazione a oggetti**.
Con il seguente ReadMe si vuole dare un breve descrizione del progetto e una rapida spiegazione del funzionamento dell'applicazione.

## Progetto
### Descrizione 

Il dataset analizzato nel programma riguarda le attività commerciali di media e grande distribuzione della città di Milano.

A partire dall'indirizzo del dataset, il programma prevede il download del file in formato JSON. Attraverso una decodifica di tale file si ottiene la URL utile per scaricare il file in formato CSV.

Successivamente viene effettuato il parsing del file CSV che permette di creare la struttura e le funzionalità della classe `Business.java.`

Infine l'utente può effettuare delle richieste sul dataset per visualizzare i dati e metadati in formato JSON e statistiche relative a numeri e stringhe. L'utente può inoltre, in fase di richiesta, inserire filtri con operatori logici e condizionali.


### Specifiche tecniche

Il programma è stato sviluppato in Java tramite l'utilizzo dell'IDE Eclipse e del framework Spring.

E' stato utilizzato Postman per valutare il corretto funzionamento del programma. Altri software utilizzati sono stati Apache Maven, Brackets e Github.


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

Nell'applicazione sono inoltre presenti diversi file:

 - `pom.xml:` ha il compito di definire identità e struttura del progetto ed è utilizzato da Maven per reperire le dipendenze del progetto
 - `appication.yml:` utilizzato per definire la porta e il percorso dell'applicazione
 - `diagrammi UML:`per una visione generale del progetto e una migliore comprensione dei collegamenti tra classi
 
### Diagrammi

Di seguito sono riportati i diagrammi utili per la comprensione del progetto

![UML](https://github.com/LauraDellaSciucca/Exam/blob/master/UML.png)

[Link](https://github.com/LauraDellaSciucca/Exam/blob/master/UML.png) del diagramma delle classi

![Diagramma dei casi d'uso](https://github.com/LauraDellaSciucca/Exam/blob/master/Diagramma%20casi%20d'uso.jpg)

[Link](https://github.com/LauraDellaSciucca/Exam/blob/master/Diagramma%20casi%20d'uso.jpg) del diagramma dei casi d'uso

## Rapida guida per l'utilizzo
### Statistiche

Restituisce tutti i **dati** recuperati tramite il file CSV 
>http://localhost:8080/Spring/api/business/

Restituisce i **metadati**
>http://localhost:8080/Spring/api/business/metadata

Restituisce le attivita' in base al **codice** inserito
>http://localhost:8080/Spring/api/business/code/{code} 

Restituisce le attivita' in base al **codice di municipio** scelto
>http://localhost:8080/Spring/api/business/municipality/{code} 

Restituisce il **conteggio** delle attivita' in base alla variabile e al valore inseriti
>http://localhost:8080/Spring/api/business/count/{variable}/value/{value}

Restituisce il **numero medio** delle attivita' con la variabile e il valore inserito rispetto al totale
>http://localhost:8080/Spring/api/business/avg/{variable}/value/{value}

Restituisce il valore relativo alla variabile scelta che presenta il **numero massimo** di attivita'
>http://localhost:8080/Spring/api/business/max/{variable}

Restituisce il valore relativo alla variabile scelta che presenta il **numero minimo** di attivita'
>http://localhost:8080/Spring/api/business/min/{variable}

Restituisce la **somma** delle superfici totali delle attivita' con variabile municipio e  valore di municpio scelto dall'utente
>http://localhost:8080/Spring/api/business/sum/municipality/value/{value}

Restituisce la **deviazione standard** delle superifici totali delle varie attivita'
>http://localhost:8080/Spring/api/business/devStdB

###### Scelte utente relative alle statistiche
Le variabili tra parentesi graffe sono quelle in cui è lasciata all'utente la scelta del relativo valore. L'utente puo' scegliere tra gli attributi elencati di seguito:

- `municipality` 

- `address`

- `pHistoricalSector` 

- `CommoditiesSector`

### Filtri

Restituisce le attivita' filtrate tramite il valore di superficie totale in base al **filtro condizionale** scelto dall'utente
>http://localhost:8080/Spring/api/business/cFilter

Restituisce tutte le attivita' presenti all'**indirizzo** inserito dall'utente
>http://localhost:8080/Spring/api/business/addressFilter

Restituisce tutte le attivita' situate entro una certa **distanza da un punto** scelto dall'utente tramite i valori di latitudine e longitudine
>http://localhost:8080/Spring/api/business/dFilter


Filtra le attivita' in base all'operatore **not** restituendo tutte le attivita' tranne  quella con il valore inserito
>http://localhost:8080/Spring/api/business/filterNot

Filtra le attivita' in base a due operatori
- **in:** restituisce le attivita' con l'attributo e i valore inseriti
- **nin:** restituisce tutte le attivita' tranne quelle con attributo e valore inseriti
>http://localhost:8080/Spring/api/business/filterN

Filtra le attivita' in base a due operatori
- **and:** restituisce le attivita' che presentano tutti gli attributi richiesti con i relativi valori
- **or:** restituisce le attivita' con almeno uno dei parametri richiesti
>http://localhost:8080/Spring/api/business/lFilter

###### Scelte utente relative ai filtri
L'utente puo' scegliere tra gli attributi elencati di seguito:

- `code` 
- `address`
- `civic` 
- `addressCode`
- `signboard`
- `pHistoricalSector`
- `totalArea`
- `municipality`

N.B Nei filtri logici è possibile inserire i vari attributi separati dalla virgola


## Autori 
 - D'Antonio Angela: (https://github.com/dantonioangela) 
 - Della Sciucca Laura: (https://github.com/LauraDellaSciucca) 


