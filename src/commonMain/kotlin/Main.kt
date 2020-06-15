import com.soywiz.korev.*
import com.soywiz.korge.view.*
import me.emig.engineEmi.*

/**
 * Startpunkt für alle Programme.
 * Hier werden u.a. Ebody und CanvasElement Objekte bei der Engine registriert.
 * Es gibt drei Bereiche:
 * init : Dieser Code-Block wird zur Konfiguration der Engine verwendet. Hier kann man z.B. die Höhe und Breite des Fensters festlegen.
 * Wenn man diesen Block leer lässt, werden Standard-Werte geladen
 * viewWillLoad: Dieser Code-Block wird NACH der Konfiguration aber VOR dem Aufbau des Views (der Anzeige) ausgeführt. Hier sollte man
 * seine Objekte bei der Engine registrieren
 * viewDidLoad: Dieser Code-Block wird NACH dem der View komplett aufgebaut wurde ausgeführt. Hier sollte man Code platzieren, der darauf
 * angewiesen ist, dass Objekte bereits fertig erstellt und registriert wurden. Dies trifft vor allem auf Ebody Objekte zu.
 */

var kreis = Spielkreis()

suspend fun main() = Engine(){
    val kreis = Spielkreis()
    addChild(kreis)
    kreis.addUpdater {
        if (views.keys.pressing(Key.LEFT)) {
            x-=10.0
        }
        if (views.keys.pressing(Key.RIGHT)) {
            x+=10.0
        }
    }
}
