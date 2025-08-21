package com.example.impostor

val words = listOf(
    // Alltag
    "Tisch", "Stuhl", "Glas", "Teller", "Löffel", "Tasse", "Lampe", "Sofa", "Buch", "Ball",
    "Schuh", "Jacke", "Hose", "Fenster", "Tür", "Bett", "Kissen", "Decke", "Teppich", "Schrank",
    "Messer", "Gabel", "Topf", "Pfanne", "Uhr", "Bild", "Radio", "Handy", "Münze", "Becher",
    "Korb", "Blume", "Pflanze", "Seife", "Bürste", "Spiegel", "Kerze", "Schere", "Stift", "Papier",
    "Tuch", "Sack", "Nagel", "Stein", "Stock", "Seil", "Reifen", "Eimer", "Lappen",

    // Mehr Alltag
    "Vogel", "Fisch", "Auto", "Baum", "Haus", "Hund", "Katze", "Brot", "Apfel", "Ei",
    "Hand", "Fuß", "Kopf", "Ohr", "Auge", "Nase", "Mund", "Zahn", "Haar", "Bein",
    "Arm", "Herz", "Ring", "Tasche", "Schlüssel", "Hut", "Kleid", "Rock", "Zug", "Schiff",
    "Boot", "Decke", "Becher", "Kerze", "Messer",

    // Tiere
    "Hund", "Katze", "Vogel", "Fisch", "Kuh", "Schaf", "Pferd", "Hase", "Maus", "Bär",
    "Frosch", "Adler", "Esel", "Ente", "Fuchs", "Gans", "Igel", "Känguru", "Krabbe", "Löwe",
    "Otter", "Rabe", "Reh", "Schlange", "Spatz", "Tiger", "Wolf", "Zebra", "Ameise", "Biene",
    "Eule", "Falke", "Garnele", "Huhn", "Krokodil", "Qualle", "Ratte", "Schmetterling", "Schwein",
    "Taube", "Wal", "Wurm", "Ziege", "Kranich", "Luchs", "Marder", "Mücke", "Papagei", "Pfau",

    // Freizeitgegenstände
    "Ball", "Buch", "Stift", "Brett", "Karte", "Würfel", "Uhr", "Spiel", "Film", "Filmrolle",
    "Kamera", "Angel", "Rucksack", "Zelt", "Kappe", "Decke", "Kissen", "Fahrrad", "Skateboard",
    "Roller", "Schlauch", "Schal", "Seil", "Tasche", "Radio", "Musik", "Foto", "Mikrofon", "Helm",
    "Brille", "Kette", "Armband", "Zigarre", "Kugel", "Stuhl", "Kamm", "Schlüssel", "Lampe", "Hantel",
    "Schaufel", "Korb", "Ballon", "Spielzeug", "Stab", "Sprung", "Tuch",

    // Essen
    "Apfel", "Brot", "Käse", "Fisch", "Reis", "Ei", "Milch", "Salz", "Zucker", "Honig",
    "Butter", "Öl", "Fleisch", "Huhn", "Tomate", "Zwiebel", "Knoblauch", "Kartoffel", "Salat", "Pilz",
    "Orange", "Banane", "Traube", "Melone", "Nuss", "Keks", "Kuchen", "Suppe", "Joghurt", "Kaffee",
    "Tee", "Saft", "Wasser", "Pizza", "Pasta", "Gemüse", "Obst", "Wurst", "Schokolade", "Soße",
    "Speck", "Bohne", "Mais", "Lachs",

    // Technik
    "Kabel", "Motor", "Sensor", "Chip", "Akku", "Lüfter", "Stecker", "Drucker", "Monitor", "Bildschirm",
    "Tastatur", "Maus", "Antenne", "Lampe", "Gerät", "Router", "Kamera", "Mikrofon", "Lautsprecher", "Schalter",
    "Netzteil", "Batterie", "Drohne", "Roboter", "Satellit", "Prozessor", "Festplatte", "Speicher", "Scanner", "USB",
    "Server", "Tablet", "Smartphone", "Fernbedienung", "Fernseher", "Platine", "Steuerung", "Adapter", "Transistor", "Elektrode",
    "Transformator", "Kondensator", "Diode",

    // Fortbewegungsmittel
    "Auto", "Boot", "Zug", "Rad", "Bus", "Taxi", "Schiff", "Flug", "Kanu", "Jeep",
    "LKW", "Moped", "Motorrad", "Roller", "Traktor", "Wagen", "Fähre", "Kutsche", "Hubschrauber", "Fahrrad",
    "E-Bike", "Straßenbahn", "U-Bahn", "Segel", "Ruder", "Flugzeug", "Helikopter", "E-Scooter", "Skate",

    // Landschaftsbegriffe
    "Berg", "Tal", "Wald", "See", "Fluss", "Hügel", "Wiese", "Strand", "Sand", "Felsen",
    "Moor", "Sumpf", "Klippe", "Düne", "Teich", "Quelle", "Acker", "Flur", "Hain", "Bach",
    "Gletscher", "Fjord", "Schlucht", "Steppe", "Oase", "Vulkan", "Plateau", "Höhle", "Kamm",
    "Busch", "Baum", "Gras", "Ebene", "Meer", "Küste", "Geysir", "Wasserfall", "Stein", "Kessel", "Mulde",

    "Abfluss","Acker","Akku","Akne","Aktionär","Albtraum","Alligator","Amerika","Anwendung","Apfelmus","Applaus","Archäologe","Aristokratie","Arm","Armada","Armbanduhr","Astronaut","Athlet","Atlantis","Aufzug","Augenbraue","Auto","Avocado","Babysitter","Baguette","Ballon","Banane","Baseball","Basketball","Bauer","Baum","Bauplan","Beethoven","Bein","Beitrag","Benzin","Berg","Besen","Beule","Bevölkerung","Bier","Birne","Blase","Bleichmittel","Bleistift","Blume","Blütezeit","Bob","Bobschlitten","Bohnenstange","Bombe","Boot","Brainstorming","Braut","Bremslicht","Brief","Brille","Brokkoli","Brücke","Brunft","Buch","Büffel","Buntstift","Büro","Bus","Cafeteria","Campingplatz","Cheerleaderin","Clown","Computer","Cowboy","Creme","Dame","Dankbarkeit","Decke","Decke","Defekt","demontieren","Deponie","Dictionary","Dieb","Doktor","Dominosteine","Donner","Dose","Drachen","Drehzahlmesser","Dreieck","Dusche","Düse","Ebene","Ebenholz","Efeu","Eidechse","Eimer","Einbruch","Einladung","Eis","Eisbahn","Elefant","Elektrizität","Elf","Ente","Entwicklung","Erfindung","Erweiterung","Europa","Fahnenmast","Fahrrad","Fahrrad","Farbe","Faulenzerin","Feder","Fehler","Fernseher","Festessen","Feudalismus","Feuer","Finger","Fischen","Flanell","Fliege","Floß","Flugzeug","Folie","Foto","Fracht","Frankreich","Franse","Frosch","Fußball","Galopp","Gang","Garten","Gasthaus","Gebäck","Geburtstag","Gedicht","Gefährte","Geländer","Geld","Gelee","Gespräch","Gewebe","Gitarre","Gleichgültigkeit","Glockenspiel","Glühbirne","Gold","Graben","Gras","Griff","Grippe","Grossbritannien","Grübchen","Gummierung","Gürtel","Haare","Hai","Hälfte","Handschrift","Hase","Haus","Hausaufgaben","Hausboot","Hecke","Hemd","Herausgeber","Herd","Herde","Herz","Hinweis","Hochschule","Hochzeit","Hockey","Hose","Hubschrauber","Hügel","Huhn","Hund","Hundehütte","Hupen","Hüpfspiel","Hürde","Husten","Hut","Hütte","Ingwer","Inquisition","Internet","Jahrhundert","Japan","Jeans","Journal","Junge","Juwel","Kabine","Kabine","Kanada","Kapitalismus","Kartographie","Karton","Kasten","Katze","Kaugummi","Kegel","Kerze","Kilogramm","Kinderbett","Kirche","Kissen","Klappe","Klavier","Kleid","Klempner","Klippe","Knie","Knöchel","Koala","Kohle","Komfort","König","Kontinuum","Kopfschmerzen","Kord","Körper","Krähe","Kreide","Kreisverkehr","Kreuzfahrt","kritisieren","Krümel","Krümmer","Kruste","Küche","Kuchen","Küchenchef","Kuh","Kumpel","Kutikula","Lachen","Lachs","Ladegerät","Laken","Lappen","Lätzchen","Lebensstil","Lebkuchen","Leck","Lehrer","Leiter","Licht","Lichtschwert","Lied","Ligament","Limette","LKW","Löffel","Löwe","Loyalität","Luftbefeuchter","Luftschiff","Lunchpaket","Macho","Mädchen","Mäher","Mama","Mammut","Manschette","Marienkäfer","Marionette","Marke","Markierung","Mars","Maschine","Maskottchen","Maßstab","Mast","Matratze","Maus","Meister","Messer","Mexiko","Mine","Mittagessen","Mond","Monitor","Monster","Montag","Mörderin","Morgendämmerung","Motor","Motorhaube","Motorrad","Motte","Müll","Müll","Müllhalde","Muschel","Musik","Nachbarin","Nacht","Nachtrag","Narbe","Nase","Natur","Nebel","Nest","Neutron","Nichte","Niesen","Null","Öffner","Ohr","Öl","Olympionike","Opa","Organ","Ouvertüre","Ovation","Pailletten","Palast","Papa","Papier","Papier","Park","Parodie","Partei","Passwort","Peitschenhieb","Pendel","Penis","Penny","Perücke","Pfeffer","Pfeife","Pfeil","Pferd","Pflug","Pfosten","Philosoph","Picknick","Pilot","Ping","Ping","Pirat","Plaid","Plakatwand","Plan","Planke","Platte","Pomp","Pool","Portfolio","Porzellan","Postfach","Praktikant","Prinzessin","Protestant","Protokoll","Psychologin","Pullover","Punk","Punkt","Punkt","Puppe","Pyjama","Quarantäne","Radio","Rand","Rasen","Rasenmäher","Rätsel","Rätsel","Raum","Raum","Rechner","Recht","Regenbogen","Regenwasser","Reise","Reißverschluss","Rennen","Rippe","Rolle","Rollstuhl","Rolltreppe","Rose","Rückerstattung","Rückgrat","Ruder","Runde","Runde","Saison","Salz","Sandburg","Sandkasten","Sandwich","Sängerin","Satellit","Satz","Satz","Saum","Schach","Schafe","Schärpe","Schatz","Scheuern","Schiffbruch","Schimmel","Schläger","Schlamassel","Schlamm","Schlauch","Schlaufe","Schlittschuh","Schlittschuhlaufen","Schlüssel","Schmied","Schnabeltier","Schnecke","Schnee","Schneebesen","Schnorrer","Schnur","Schnürsenkel","Schokolade","Schreibtisch","Schule","Schurke","Schwamm","Schwarm","Schweinekoben","Schweißer","Schwimmen","Schwingen","Shampoo","Sheriff","Siesta","Silhouette","Ski","Sommersprosse","Songtexte","Sonne","Sonnenbrand","Spiel","Spielplatz","Spinne","Spion","Spitze","Sprecher","Springer","Sprinkleranlage","Sprosse","Sprung","Spucke","Spule","Stall","Staub","Stehen","Stern","Sternwarte","Stift","Stirn","Stirnrunzeln","Strahl","Strand","Streifen","Stroh","Strom","Student","Stuhl","Sumpfgebiet","Sushi","Süßigkeiten","Tag","Tante","Tasche","Tasche","Taschenlampe","Taucher","Taxi","Teekanne","Teenager","Telefon","Telefon","Tennis","Thron","Tide","Tiger","Tischtennis","Toast","Toilette","Ton","Tönung","Tornado","Trainer","Traktor","Traube","Traum","Treibgut","Treibsand","Treppe","Trockner","Trommeln","Tropfen","Tuba","Tür","Turnier","Tutorin","Typ","Uhrwerk","Ulme","Umarmung","Umhang","Umhang","Umlaufbahn","Unentschieden","Unkraut","Untersetzer","Upgrade","Ventilator","Verengung","Verzögerung","Vision","Vogel","Vorhang","Vorrichtung","Wachs","Wanne","Wanze","Wäscherei","Wasser","Wassermelone","Welle","Welpe","Welt","Werkzeug","Weste","Wille","Windmühle","Windrad","Winter","Wischmopp","Wolf","Wolle","Wunsch","Zahnarzt","Zahnbürste","Zahnrad","Zar","Zaun","Zeit","Zelle","Zirkus","Zone","Zoo","Zug","Zündholz","Zustand","Zweig","Zwerg"
)