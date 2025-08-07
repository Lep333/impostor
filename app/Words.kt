val words = listOf(
    "Roman", "Erzählung", "Kapitel", "Absatz", "Satz", "Wort", "Buchstabe", "Grammatik", "Rechtschreibung", "Lesung",
    "Fabel", "Märchen", "Essay", "Biografie", "Bibliothek", "Verlag", "Autor", "Leserin", "Literatur", "Genre",
    "Zitat", "Poesie", "Reim", "Metapher", "Symbol", "Stilmittel", "Redewendung", "Synonym",
    "Umschlag", "Klappentext", "Inhaltsverzeichnis", "Fußnote", "Druck", "Handschrift", "Tinte", "Papier",
    "Schreibmaschine", "Manuskript", "Kritiker", "Bestseller", "Buchhandlung", "Schreibtisch",

    "Superheld", "Schurke", "Maske", "Cape", "Heft", "Sprechblase", "Zeichnung",
    "Ausgabe", "Verkleidung", "Geheimidentität",
    "Mutanten", "Abenteuer", "Parodie", "Karikatur", "Action", "Explosion",
    "Geschichte", "Superkraft", "Kostüm", "Universum", "Gegner", "Zeichner", "Szene",
    "Charakter", "Zeitreise", "Transformation",

    "Spielwelt", "Controller", "Maus", "Tastatur", "Monitor", "Headset", "Konsole", "Mission",
    "Endgegner", "Charakter", "Fähigkeit", "Waffe", "Munition", "Rüstung",
    "Grafik", "Dialog", "Server", "Trophäe", "Rangliste", "Arena",
    "Simulation", "Strategie", "Puzzle", "Gegner",

    "iPod", "SMS", "Klingelton", "Discman", "MP3",
    "Röhrenbildschirm", "Festival", "Bluetooth", "Y2K", "Skateboard",
    "Tattoo", "Piercing",
    "Poster", "Diashow", "Chat", "Selfie", "Emo",
    "Schulranzen", "Parfüm", "Brille", "Modem",

    "Wald", "Wiese", "Baum", "Strauch", "Busch", "Blume", "Blatt", "Moos", "Pilz", "Schmetterling",
    "Biene", "Vogel", "Fuchs", "Reh", "Eichhörnchen", "Ameise", "Erde", "Rinde", "Wurzel", "Ast",
    "Zweig", "Tannenzapfen", "Lichtung", "Wanderweg", "Aussicht", "Natur", "Himmel", "Sonne", "Regen", "Nebel",
    "Wind", "Wolke", "Zelt", "Lagerfeuer", "Hängematte", "Fernglas", "Rucksack", "Picknick", "Quelle",
    "Wassertropfen", "Teich", "Bach", "Felsen", "Klee", "Distel", "Wildblume", "Insekt", "Pfad", "Wanderweg",
    "Hund", "Katze", "Pferd", "Kuh", "Schwein", "Schaf", "Ziege", "Huhn", "Gans", "Ente",
    "Esel", "Kaninchen", "Hamster", "Meerschweinchen", "Ratte", "Maus", "Fuchs", "Wolf", "Bär", "Luchs",
    "Igel", "Dachs", "Marder", "Otter", "Reh", "Hirsch", "Wildschwein", "Mufflon", "Feldhase", "Waschbär",
    "Frosch", "Kröte", "Salamander", "Molch", "Schlange", "Eidechse", "Chamäleon", "Krokodil", "Alligator", "Schildkröte",
    "Adler", "Falke", "Eule", "Uhu", "Specht", "Schwalbe", "Taube", "Amsel", "Spatz", "Storch",

    "Apfel", "Birne", "Banane", "Orange", "Erdbeere", "Traube", "Salat", "Tomate", "Gurke", "Paprika",
    "Karotte", "Kartoffel", "Brokkoli", "Spinat", "Zwiebel", "Knoblauch", "Brot", "Brötchen", "Baguette", "Croissant",
    "Butter", "Käse", "Joghurt", "Milch", "Sahne", "Quark", "Ei", "Wurst", "Schinken",
    "Fisch", "Reis", "Nudeln", "Pizza", "Burger", "Suppe", "Eintopf", "Kuchen", "Torte", "Keks",
    "Schokolade", "Bonbon", "Eis", "Saft", "Tee", "Kaffee", "Wasser", "Limo", "Bier", "Wein",

    // Glaube & Religion
    "Kirche", "Tempel", "Moschee", "Synagoge", "Altar", "Glocke",
    "Gebet", "Ritual", "Taufe", "Gottesdienst", "Fasten", "Kreuz",
    "Engel", "Teufel", "Heilige", "Papst", "Priester", "Mönch", "Nonne", "Imam", "Rabbi",
    "Segen", "Beichte", "Chor", "Gemeinde", "Kloster", "Ikone", "Glaube",
    "Schöpfung", "Jenseits", "Himmel", "Hölle", "Paradies", "Wiedergeburt",

    // Im Labor
    "Reagenzglas", "Bunsenbrenner", "Pipette", "Trichter", "Waage", "Mikroskop",
    "Thermometer", "Rührgerät", "Kühlschrank", "Schutzbrille",
    "Handschuhe", "Kittel", "Chemikalie", "Substanz", "Lösung", "Reaktion", "Analyse", "Versuch",
    "Experiment", "Formel", "Protokoll", "Diagramm", "Skizze", "DNA", "Zelle", "Molekül",
    "Bakterium", "Virus", "Kultur", "Probe", "Dosierung", "Forschung",

    // Kinofilme
    "Film", "Kamera", "Drehbuch", "Schauspieler", "Szene", "Kulisse", "Studio",
    "Kostüm", "Maske", "Schminke", "Ton", "Mikrofon", "Licht",
    "Schnitt", "Effekte", "Musik",
    "Festival", "Zuschauer", "Popcorn", "Ticket", "Reservierung",
    "Komödie", "Drama",

    // Kunst & Kultur
    "Malerei", "Zeichnung", "Skulptur", "Fotografie", "Farbe", "Pinsel",
    "Galerie", "Ausstellung", "Museum", "Kunstwerk",
    "Schatten", "Licht",
    "Performance", "Theater", "Bühne", "Aufführung", "Schauspiel",
    "Tanz", "Orchester", "Musik", "Denkmal", "Kreativität",

    // Körper & Geist
    "Körper", "Geist", "Gehirn", "Herz", "Lunge", "Magen", "Sinne", "Auge", "Ohr", "Nase", "Haut", "Mund",
    "Gedanke", "Gefühl", "Emotion", "Bewusstsein", "Reflex", "Schmerz", "Freude", "Angst", "Stress",
    "Entspannung", "Ruhe", "Schlaf", "Traum", "Denken", "Erinnerung", "Konzentration",
    "Identität", "Verstand", "Trieb", "Wille", "Erkenntnis", "Erfahrung",

    // Macht & Geld
    "Geld", "Macht", "Einfluss", "Reichtum", "Vermögen", "Kapital", "Bank", "Kredit", "Zins", "Schuld",
    "Börse", "Aktie", "Anleihe", "Münze", "Schein", "Lohn", "Gehalt", "Einnahme",
    "Ausgabe", "Gewinn", "Verlust", "Budget", "Konto", "Überweisung", "Finanzamt", "Steuer",
    "Bestechung", "Korruption", "Herrschaft", "Unternehmen",
    "Minister", "Wirtschaft", "Bankrott", "Spende",

    // Medien & Unterhaltung
    "Nachricht", "Zeitung", "Radio", "Fernsehen",
    "Interview", "Bericht", "Kommentar", "Podcast",
    "Reichweite", "Skandal", "Gerücht", "Netzwerk", "Algorithmus",
    "Reaktion", "Trend", "Meme",

    // Musik & Hits
    "Musik", "Lied", "Takt", "Note", "Album",
    "Lautsprecher",
    "Verstärker", "Kopfhörer",
)