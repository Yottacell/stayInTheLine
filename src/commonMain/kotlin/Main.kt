import com.soywiz.korev.*
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import me.emig.engineEmi.*
import me.emig.engineEmi.graphics.shapes.Rechteck

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

    val r0 = Rechteck(175, 275,50,150, fillColor = Colors.BLACK)
    val r1 = Rechteck(175, -150,425,50, fillColor = Colors.BLACK)
    val r2 = Rechteck(275, -225,500,50, fillColor = Colors.BLACK)
    val r3 = Rechteck(-25, -150,50, 200, fillColor = Colors.BLACK)
    val r4 = Rechteck(75, -275,50,250, fillColor = Colors.BLACK)
    val r5 = Rechteck(-25, -425,275,50, fillColor = Colors.BLACK)
    val r6 = Rechteck(-25, -475,50,450, fillColor = Colors.BLACK)
    val r7 = Rechteck(250, -325,50,225, fillColor = Colors.BLACK)
    val r8 = Rechteck(475, -725,450,50, fillColor = Colors.BLACK)
    val r9 = Rechteck(375, -725,125,50, fillColor = Colors.BLACK)
    val r10 = Rechteck(375, -550,75,50, fillColor = Colors.BLACK)
    val r11 = Rechteck(325, -550,50,50, fillColor = Colors.BLACK)
    val r12 = Rechteck(275, -725,225,50, fillColor = Colors.BLACK)
    val r13 = Rechteck(460, -725,100,15, fillColor = Colors.BLACK)

    val rechtecke = arrayOf(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)

    rechtecke.forEach {
        addChild(it)
    }

    addChild(kreis)
    kreis.addUpdater {
        if (views.keys.pressing(Key.LEFT)) {
            x-= 6
        }
        if (views.keys.pressing(Key.RIGHT)) {
            x+= 6
        }
    }

    addUpdater {
        rechtecke.forEach {
            it.y += 2
        }
    }

    /*onCollision() {
        addUpdater {
            rechtecke.forEach {
                    it.y -= 5
            }
        }
    }*/
}