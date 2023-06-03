
# GDE alkalmazásfejlesztés VIZSGA 2023.05.25 17:30-20:30

Ez a 2023.05.25-i vizsga feladat
A megoldásra 3 órátok van. A vizsga 17:30-20:30-ig tart.
A github-on lévő utolsó commit nem lehet 20:30 után. Csak az azelőtti utolsó commmit-ot veszem figyelembe az értékelésnél.


## Általános elvárások
- ezt a projektet töltsétek le IntelliJ IDEA-ba és onnan osszátok meg a saját github repositorytokba PUBLIC-ra
- a "tesztkerdesek.txt"-ben töltsétek ki a neveteket, szakotokat és neptun kódotokat
- mindig csináljatok commit-ot, amikor annak a helyét és idejét látjátok (0-5 pont)
- 3 órátok van a feladat megoldására, és github-ra való push-olására
- hogy biztos legyen, a végén egy browser incognito ablakában nézzétek meg az elküldendő github repositoryt (látható, fent van az utolsó commit is)
- a feladat elvégzése végén küldjétek el nekem email-ben a boga.aron@gde.hu címre a github repositorytok url-jét
- a feladatot a clean code elvek szerint végezzétek el


## 1. A tesztkérdések (25%) -> minden pont 2,5%

A válasz helyre írjátok be a helyes választ. Jó válasz 1 pont, rossz válasz -1 pont, nincs válasz 0 pont. 0-3 pontig bukás, fölötte 25%-ban számít bele az érdemjegybe.

## 2. Programozási feladat (75%) -> minden pont 1,5%

A példaprogramban Futók és köridők szerepelnek. Ezeket lehet megtekinteni, illetve új köridőt rögzíteni egy Thymeleaf frontenden.
A futókat adatait a DataLoader inicializálja
Fordítás után:
http://localhost:8080

Illetve el lehet érni az adatokat REST api-kon keresztül, felvenni új köridőt egy futóhoz.
Ezekhez a Postman collectiont a /src/test/postman/ könyvtárban találjátok.
A feladatok elvégzése után a módosított (Postman-ből kiexportált) collection-nel írjátok felül ezt!

### Feladatok

- Vegyetek fel egy magasság (height) adatot minden futóhoz. (2p)
- Ezt töltsétek ki inicializáciokor a két futóra. (1p)
- Vegyetek fel egy harmadik futót tetszőleges adatokkal (1p)
- Csináljatok egy GET REST végpontot, ahol le lehet kérdezni a legmagasabb futo nevét. (5p)
- Bővítsétek a postman collectiont erre a fenti végpontra való kéréssel (3p)
- Írjátok ki a futók átlagmagasságát a http://localhost:8080/runners címen a futók listája alá (5p)
- Vezessetek be egy új szponzor entitást Sponsor néven (azonosító, név) egy futót egy szponzor szponzorálhat (oneToMany) (5p)
- Adjatok hozzá minden futóhoz inicializációkor egy szponzort (3p)
- A futó részletek http://localhost:8080/runner/{id} képernyőjén mutassuk meg a szponzort (3p)
- Írjatok egy REST végpontot, ahol id alapján lehet változtatni a futó szponzorát (6p)
- Bövítsétek a postman collectiont ezzel a kéréssel (1p)
#### Részfeladatok összesen 35 pont
+ commitok minősége max 5 pont
+ clean code elvárásoknak való megfelelés max 10 pont
#### Összesen 50 pont

Jó munkát! Légyszi önálló munkában, internettel...
