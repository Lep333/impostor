package com.example.impostor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.impostor.ui.theme.ImpostorTheme

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
    "Busch", "Baum", "Gras", "Ebene", "Meer", "Küste", "Geysir", "Wasserfall", "Stein", "Kessel", "Mulde"
)