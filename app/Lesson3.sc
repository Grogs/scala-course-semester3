case class Artist(name: String, albums: Seq[Album])
case class Album(name: String, released: Int, tracks: Seq[Track])
case class Track(name: String, durationSeconds: Int)

val someData = Seq(
    Artist("Megadeth", Seq(
        Album("Rust in Peace", 1990, Seq(
            Track("Hangar 18", 5*60 + 15),
            Track("Take No Prisoners", 3*60 + 27),
            Track("Five Magics", 5*60 + 39)
        )),
        Album("Countdown to Extinction", 1992, Seq(
            Track("Symphony of Distruction", 4*60 + 2),
            Track("This Was My Life", 3*60 + 42),
            Track("Countdown to Extinction", 4*60 + 17)
        ))
    )),
    Artist("Rationale", Seq(
        Album("Fuel To The Fire", 2015, Seq(
            Track("Fast Lane", 2*60 + 35),
            Track("Re.Up", 3*60 + 11)
        ))
    )),
    Artist("Pavement", Seq(
        Album("Crooked Rain Crooked Rain", 1995, Seq(
            Track("Cut Your Hair", 3*60 + 7),
            Track("Range Life", 4*60 + 55)
        ))
    ))
)

someData.find(a => a.name == "Pavement")









