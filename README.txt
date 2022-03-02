In cadrul implementarii sistemului de licitatii, am folosit conceptele POO:
	- incapsulare
	- mostenire(clase parinte Produs, Angajat, Client)
	- abstractizare(clase abstracte Angajat, Produs)
	- polimorfism.

De asemenea, am folosit genericitatea(clasa Pair in special, dar si folosirea
listelor de tip ArrayList<>).

Cele 4 design patterns implementate sunt:
	- Singleton, pentru clasa CasaDeLicitatii, intrucat exista o singura
	casa de licitatii(are o singura instanta), astfel si furnizand un punct
	global de acces la ea
	
	- Builder, asupra Client, pentru a putea creea o instanta mai usor(format
	human readable), luand in considerare faptul ca un Client are multe
	variabile membru

	-Factory, pentru a crearea mai usoara a produselor (clasa Produs este
	abstracta, fiind extinsa de clasele Bijuterie, Tablou si Mobila)

	-Command, pentru a incapsula orice cerere(comanda din fisier) ca obiect,
	astfel ca este mai usoara si mai clara executarea actiunilor (clasa
	Comanda este o interfata, existand mai multe comenzi concrete).

Nu in ultimul rand, am folosind multithreading, creandu-se cate un thread pentru
fiecare licitatie si respectand toate constrangerile specificate, astfel ca, la
rulare se poate observa faptul ca apar comenzi intercalate.

In final, pentru testarea aplicatiei, am folosit 10 fisiere input ce contin
comenzile care trebuie executate, numite "comenzi0.txt" - "comenzi9.txt".
De asemenea, am folosit fisiere pentru crearea si adaugarea produselor
(produse1.txt,produse2.txt,produse3.txt).
	