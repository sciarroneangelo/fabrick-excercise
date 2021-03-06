# fabrick-excercise


## Lettura Saldo
* La lettura del saldo è eseguita dal controller dev.asciarrone.fabricktest.controller.BalanceControllerTest.java. 
* L'url da richiamare è: http://localhost:8080/fabrick-test/v1.0/api/balance/getLastBalance
* Va passato un json contente l'accountId: 
```
	{"accountId":"14537780"}
```
* Con i parametri sopra riportati si avrà la seguente risposta di esempio: 
```
	{
		"date": "2020-07-03T00:00:00.000+00:00",
		"balance": -0.39,
		"availableBalance": -0.39,
		"currency": "EUR"
	}
```
* Sono previste due classi di test **jUnit** una per il controller ed una per il relativo service, possono essere trovate nel source folder di test con i seguenti riferimenti:
 * dev.asciarrone.fabricktest.controller.BalanceControllerTest.java (testa il controller)
 * dev.asciarrone.fabricktest.service.BalanceServiceTest.java (testa il servizio).

## Inserimento Bonifico
* L'inserimento del bonifico viene eseguito tramite il controller dev.asciarrone.fabricktest.controller.TransactionController.java. 
* L'url da richiamare è : http://localhost:8080/fabrick-test/v1.0/api/balance/getLastBalance
* Va passato un json come il seguente: 
```
	{
		"accountId": "14537780",
		"receiverName": "John Doe",
		"description": "description",
		"currency": "EUR",
		"amount": "800",
		"executionDate": "03/07/2020"
	}
```
 * accountId: identificativo del conto.
 * receiverName: nome del beneficiario
 * description: causale
 * currency: valuta secondo lo standard ISO 4217
 * executionDate_ data di esecuzione del bonifico.
* Le specifiche non affrontavano l'analisi di come reperire i dati mancanti per la chiamata all'API di Fabrick (es. IBAN). Si è scelto di creare un'anagrafica su un *in-memory database* utlizzando il parametro *receiverName* come chiave. Se si volessero inserire altri beneficiari basta aggiungerli nel file data.sql prima di eseguire l'applicazione. Sono state ignorate le informazioni fiscali in quanto opzionali.
* Con i parametri sopra riportati si avrà la seguente risposta di esempio: 
```
	{
		"errors": [{
			"code": "API000",
			"description": "Errore tecnico  La condizione BP049 non e' prevista per il conto id 14537780"
		}],
		"status": "KO"
	}
```
* Sono previste due classi di test **jUnit** una per il controller ed una per il relativo service, possono essere trovate nel source folder di test con i seguenti riferimenti:
 * dev.asciarrone.fabricktest.controller.TransferControllerTest.java (testa il controller)
 * dev.asciarrone.fabricktest.service.TransferServiceTest.java (testa il servizio).

## Lista operazioni
* La lista delle operazioni viene ricavata tramite il controller dev.asciarrone.fabricktest.controller.TransactionController.java.
* L'url da richiamare è: http://localhost:8080/fabrick-test/v1.0/api/transaction/transactionList?accountId=14537780&fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01
	Si possono notare alcuni parametri di esempio che verranno passati all'API per reperire la lista.
* Con i parametri sopra riportati si avrà la seguente risposta di esempio: 
```
[{
	"transactionId": "282831",
	"operationId": "00000000282831",
	"accountingDate": "2019-11-29",
	"valueDate": "2019-12-01",
	"amount": "-343.77",
	"currency": "EUR",
	"description": "PD VISA CORPORATE 10",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
	}
}, {
	"transactionId": "1460159524001",
	"operationId": "19000191134336",
	"accountingDate": "2019-11-11",
	"valueDate": "2019-11-09",
	"amount": "854.00",
	"currency": "EUR",
	"description": "BD LUCA TERRIBILE        DA 03268.49130         DATA ORDINE 09112019 COPERTURA VISA",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0010"
	}
}, {
	"transactionId": "032067",
	"operationId": "00000000032067",
	"accountingDate": "2019-10-31",
	"valueDate": "2019-11-01",
	"amount": "-407.75",
	"currency": "EUR",
	"description": "PD VISA CORPORATE 09",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
	}
}, {
	"transactionId": "224892",
	"operationId": "00000000224892",
	"accountingDate": "2019-09-30",
	"valueDate": "2019-10-01",
	"amount": "-507.88",
	"currency": "EUR",
	"description": "PD VISA CORPORATE 08",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
	}
}, {
	"transactionId": "1433790655001",
	"operationId": "19000155036506",
	"accountingDate": "2019-09-16",
	"valueDate": "2019-09-16",
	"amount": "100.00",
	"currency": "EUR",
	"description": "GC LUCA TERRIBILE        DA 03268.22300         DATA ORDINE 16092019 TEST",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0034"
	}
}, {
	"transactionId": "428524",
	"operationId": "00000000428524",
	"accountingDate": "2019-06-28",
	"valueDate": "2019-07-01",
	"amount": "-38.90",
	"currency": "EUR",
	"description": "PD VISA CORPORATE 05",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
	}
}, {
	"transactionId": "1390057989001",
	"operationId": "19000095363538",
	"accountingDate": "2019-06-14",
	"valueDate": "2019-06-14",
	"amount": "90.00",
	"currency": "EUR",
	"description": "BD LUCA TERRIBILE        DA 03268.44430         DATA ORDINE 14062019 RIMBORSO VISA",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0010"
	}
}, {
	"transactionId": "314569",
	"operationId": "00000000314569",
	"accountingDate": "2019-05-31",
	"valueDate": "2019-06-01",
	"amount": "-28.40",
	"currency": "EUR",
	"description": "PD VISA CORPORATE 04",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
	}
}, {
	"transactionId": "038917",
	"operationId": "00000000038917",
	"accountingDate": "2019-04-30",
	"valueDate": "2019-05-01",
	"amount": "-62.40",
	"currency": "EUR",
	"description": "PD VISA CORPORATE 03",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
	}
}, {
	"transactionId": "1345764567001",
	"operationId": "19000039371017",
	"accountingDate": "2019-03-11",
	"valueDate": "2019-03-11",
	"amount": "3.00",
	"currency": "EUR",
	"description": "GC LUCA TERRIBILE        DA 03268.22300         DATA ORDINE 11032019 TEST",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0034"
	}
}, {
	"transactionId": "566717",
	"operationId": "00000000566717",
	"accountingDate": "2019-03-04",
	"valueDate": "2019-03-02",
	"amount": "55.00",
	"currency": "EUR",
	"description": "GC LUCA TERRIBILE",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0034"
	}
}, {
	"transactionId": "682654",
	"operationId": "00000000682654",
	"accountingDate": "2019-02-28",
	"valueDate": "2019-03-01",
	"amount": "-57.20",
	"currency": "EUR",
	"description": "PD VISA CORPORATE 01",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
	}
}, {
	"transactionId": "1329140278001",
	"operationId": "19000017094683",
	"accountingDate": "2019-02-01",
	"valueDate": "2019-02-01",
	"amount": "89.00",
	"currency": "EUR",
	"description": "GC LUCA TERRIBILE        DA 03268.22300         DATA ORDINE 01022019 COPERTURA SPESE",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0034"
	}
}, {
	"transactionId": "398894",
	"operationId": "00000000398894",
	"accountingDate": "2019-01-31",
	"valueDate": "2019-02-01",
	"amount": "-95.73",
	"currency": "EUR",
	"description": "PD VISA CORPORATE 12",
	"type": {
		"enumeration": "GBS_TRANSACTION_TYPE",
		"value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
	}
}]
```
* Sono previste due classi di test **jUnit** una per il controller ed una per il relativo service, possono essere trovate nel source folder di test con i seguenti riferimenti:
 * dev.asciarrone.fabricktest.controller.TransactionControllerTest.java (testa il controller)
 * dev.asciarrone.fabricktest.service.TransactionControllerTest.java (testa il servizio).
* E' stato predisposto il salvataggio delle transazioni su di un *in-memory database* utlizzando l'ORM Hibernate. Per il dettaglio vedere le seguenti classi e interfacce:
 * dev.asciarrone.fabricktest.db.dto.TransactionDto.java
 * dev.asciarrone.fabricktest.db.repository.TransactionTypeRepository.java
 * dev.asciarrone.fabricktest.db.dto.TransactionTypeDto.java
 * dev.asciarrone.fabricktest.db.repository.TransactionRepository.java
 
## Varie
Durante la chiamata alle API ho notato che i nomi dei campi della risposta cambiano nel caso in cui si verifica un errore. L'array json contenente il dettaglio degli errori si chiama error**s** in caso di errore, mentre viene definito error (senza la s) in caso di risposta corretta. Questo mi ha portato a mapparlo due volte lo stesso oggetto nel Bean Java usato per deserializzare la risposta.