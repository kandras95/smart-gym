
<h1>SmartGym</h1>
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

![adatbazisterv](https://user-images.githubusercontent.com/47753407/76548305-d16df780-648e-11ea-8784-7413cbe69a1a.jpg)
