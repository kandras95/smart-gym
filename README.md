
<h1>SmartGym</h1>

<h3>CircleCI</h3>
[![CircleCI](https://circleci.com/gh/kandras95/smart-gym.svg?style=svg)](https://circleci.com/gh/kandras95/smart-gym)
<br>
<br>

A felhasználó sportolását segítő alkalmazás, spring backend-del, és angular frontend-del megvalósítva.
<h2>Követelmények</h2>
<h3>Funkcionális követelmények</h3>
<p>Közös:</p>
<ul>
   <li>bejelentkezés</li>
</ul>     
<p>Sportolóként:</p>    
<ul>
   <li> meg tudjuk tekinteni az adatainkat: név, felhasználónév, súly, cél súly, magasság, e-mail cím </li>
   <li>személyes adatot változtathatunk: súly, cél súly</li>
   <li>meg tudjuk tekinteni a kapott edzéstervet</li>
   <li> értékelni tudjuk az edzőt, akitől kaptuk az edzéstervet (ezt nem csak egyszer, hanem akár hetente is megtehetjük)</li>
    <li>megtekinthetjük az edző e-mail címét, ha elért egy megadott pontszámot</li>
</ul>
      
<p>Edzőként:</p>         
<ul>
   <li>személyes adatok megtekintése: név, felhasználónév, pontszám, e-mail cím </li>
   <li>edzéstervek kilistázása a hozzá tartozó felhasználó nevével </li>
   <li>edzésterv módosítása (gyakorlat törlés, új hozzáadása) </li>
   <li> edzésterv törlése</li>
   <li>összes gyakorlat kilistázása</li>
   <li>edzésterv hozzáadása egy új felhasználóhoz</li>
</ul>
              
<h3>Nem funkcionális elvárások</h3>       
<ul>
   <li>Felhasználóbarát, egyszerű, letisztult felület</li>
   <li>biztonságos működés: jelszavak tárolása, funkciókhoz való hozzáférés </li>
   <li>logikus menü elrendezés</li>
   <li>gyors működés </li>
</ul>

<h3>Szerepkörök</h3>
<ul>
    <li>Sportoló: rendelkezik belépéshez szükséges adatokkal, saját adatait tudja megtekinteni és módosítani, edzéstervét meg tudja tekinteni</li>
   <li>Edző: rendelkezik belépéshez szükséges adatokkal, saját adatait tudja megtekinteni és módosítani, edzéstervet létrehoz, módosít, megtekinti a sportolóit.</li>
</ul>

<h2>Tervezés</h2>
<h3>Adatbázis terv:</h3>

![adatbazisterv](https://user-images.githubusercontent.com/47753407/76559171-efdbef00-649e-11ea-8e14-d0820976a9b5.jpg)

----------
Vázlatos terv:
Drive-os link a szerkeszthető változat, jobban látszanak a dolgok:
https://drive.google.com/open?id=1EyClmUDdWK5D0ucnKWybXwGYkkTQ71jH

Login ablak:
![login](https://user-images.githubusercontent.com/47753407/76700613-8683f800-66b9-11ea-8015-f60d443cb091.png)


Kezdőoldal kinézete, itt nem csináltam külön-külön felhasználó, edző nézetet. Edző módosíthatja a saját magasságát, súlyát, de szerintem nem fontos. Edző látja a pontszámát, felhasználónak nincs ilyen adata.
![home](https://user-images.githubusercontent.com/47753407/76700615-8edc3300-66b9-11ea-93f4-37c632b9e260.png)

Ez a Plans kinézete, a felhasználó megtekintheti az edzéstervét. Nem tudom lehessen-e több féle edzésterve egy felhasználónak, vagy az az egyetlen edző módosítgat.
![plan_user](https://user-images.githubusercontent.com/47753407/76700637-c519b280-66b9-11ea-9a87-3a06e1a33a57.png)


Edző nézete a Plansnél, kilistázva a hozzá tartozóm edzéstervek, amiket törölhet kompletten, vagy módosíthat rajta valamit, ha módosít, akkor egy kis felugró ablak legyen, ahol a gyakorlatok közül kiválaszthat 1-et a lenyíló részen. Majd addal hozzáadja. A végén pedig véglegesíti
![plan_trainer1](https://user-images.githubusercontent.com/47753407/76700640-c814a300-66b9-11ea-85e6-dce552dd63ed.png)

![plan_trainer2](https://user-images.githubusercontent.com/47753407/76700641-cb0f9380-66b9-11ea-8586-e87709888c37.png)

--------
Eddig ennyi. Ne feledjétek a kézfertőtlenítőt!
