import java.util.*;

public class maraton_derece {
    static class Yarismaci {
        String isim;
        int derece;

        Yarismaci (String isim, int derece) {
            this.isim = isim;
            this.derece = derece;
        }
    }
    public static void main(String[] args) {
        Yarismaci [] ogrenciler = {
                new Yarismaci("Kadir", 341),
                new Yarismaci("Gökhan", 273),
                new Yarismaci("Hakan", 278),
                new Yarismaci("Suzan", 329),
                new Yarismaci("Pınar", 445),
                new Yarismaci("Mehmet", 402),
                new Yarismaci("Ali", 388),
                new Yarismaci("Emel", 270),
                new Yarismaci("Fırat", 243),
                new Yarismaci("James", 334),
                new Yarismaci("Jale", 412),
                new Yarismaci("Ersin", 393),
                new Yarismaci("Deniz", 299),
                new Yarismaci("Gözde", 343),
                new Yarismaci("Anıl", 317),
                new Yarismaci("Burak", 265)
        };

        List<Yarismaci> ilkUc = ilkUcDereceyiBul(ogrenciler);
        System.out.println("İlk üç dereceyi alan öğrenciler:");
        for (Yarismaci ogrenci : ilkUc) {
            System.out.println(ogrenci.isim + ": " + ogrenci.derece + " dakika");
        }

        int enDusukIndex = enDusukZamanaSahipKisiIndex(ogrenciler);
        Yarismaci enDusukKisi = ogrenciler[enDusukIndex];
        System.out.println("En düşük zamana sahip kişi: " + enDusukKisi.isim + ", " + enDusukKisi.derece + " dakika");

        Yarismaci ikinciEnIyi = ikinciEnIyiKosucu(ogrenciler);
        System.out.println("İkinci en iyi koşucu: " + ikinciEnIyi.isim + ", " + ikinciEnIyi.derece + " dakika");

        Yarismaci ucuncuEnIyi = ucuncuEnIyiKosucu(ogrenciler);
        System.out.println("Üçüncü en iyi koşucu: " + ucuncuEnIyi.isim + ", " + ucuncuEnIyi.derece + " dakika");

        Map<String, Integer> siniflar = siniflandir(ogrenciler);
        System.out.println("Sınıflar:");
        for (Map.Entry<String, Integer> entry : siniflar.entrySet()) {
            System.out.println(entry.getKey() + " sınıfı: " + entry.getValue() + " kişi");
        }
    }

    static List<Yarismaci> ilkUcDereceyiBul(Yarismaci[] ogrenciler) {
        List<Yarismaci> siraliListe = new ArrayList<>(Arrays.asList(ogrenciler));
        siraliListe.sort(Comparator.comparingInt(o -> o.derece));
        return siraliListe.subList(0, Math.min(3, siraliListe.size()));
    }

    static int enDusukZamanaSahipKisiIndex(Yarismaci[] ogrenciler) {
        int enDusukIndex = 0;
        for (int i = 1; i < ogrenciler.length; i++) {
            if (ogrenciler[i].derece < ogrenciler[enDusukIndex].derece) {
                enDusukIndex = i;
            }
        }
        return enDusukIndex;
    }

    static Yarismaci ikinciEnIyiKosucu(Yarismaci[] ogrenciler) {
        int enDusukIndex = enDusukZamanaSahipKisiIndex(ogrenciler);
        int ikinciEnIyiIndex = (enDusukIndex == 0) ? 1 : 0;
        for (int i = 0; i < ogrenciler.length; i++) {
            if (i != enDusukIndex && ogrenciler[i].derece < ogrenciler[ikinciEnIyiIndex].derece) {
                ikinciEnIyiIndex = i;
            }
        }
        return ogrenciler[ikinciEnIyiIndex];
    }

    static Yarismaci ucuncuEnIyiKosucu(Yarismaci[] ogrenciler) {
        int enDusukIndex = enDusukZamanaSahipKisiIndex(ogrenciler);
        int ikinciEnIyiIndex = (enDusukIndex == 0) ? 1 : 0;
        int ucuncuEnIyiIndex = (ikinciEnIyiIndex == 0) ? 1 : 0;

        for (int i = 0; i < ogrenciler.length; i++) {
            if (i != enDusukIndex && i != ikinciEnIyiIndex && ogrenciler[i].derece < ogrenciler[ucuncuEnIyiIndex].derece) {
                ucuncuEnIyiIndex = i;
            }
        }
        return ogrenciler[ucuncuEnIyiIndex];
    }

    static Map<String, Integer> siniflandir(Yarismaci[] ogrenciler) {
        Map<String, Integer> siniflar = new HashMap<>();
        siniflar.put("A", 0);
        siniflar.put("B", 0);
        siniflar.put("C", 0);

        for (Yarismaci yarismaci : ogrenciler) {
            if (yarismaci.derece >= 200 && yarismaci.derece <= 299) {
                siniflar.put("A", siniflar.get("A") + 1);
            } else if (yarismaci.derece >= 300 && yarismaci.derece <= 399) {
                siniflar.put("B", siniflar.get("B") + 1);
            } else {
                siniflar.put("C", siniflar.size());
            }
        }

        return siniflar;
    }
}































