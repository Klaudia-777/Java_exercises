package comparatorComparableEx;

import java.util.Optional;

public class Pracownik implements Comparable<Pracownik> {
    private String imie;
    private String nazwisko;
    private String wiek;

    public Pracownik(String imie, String nazwisko, String wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public String getImie() {
        return Optional.ofNullable(imie).toString();
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwizko() {
        return Optional.ofNullable(nazwisko).toString();
    }

    public void setNazwizko(String nazwizko) {
        this.nazwisko = nazwizko;
    }

    public String getWiek() {
        return Optional.ofNullable(wiek).toString();
    }

    public void setWiek(String wiek) {
        this.wiek = wiek;
    }

    // nazwisko -> imie -> wiek

    public void wypisz() {
        Optional.ofNullable(imie).ifPresent(n -> System.out.println(imie));
    }

    @Override
    public int compareTo(Pracownik pracownik) {

        if (Optional.ofNullable(nazwisko).toString().compareTo(pracownik.getNazwizko()) != 0)
            return Optional.ofNullable(nazwisko).toString().compareTo(pracownik.getNazwizko());
        if (Optional.ofNullable(imie).toString().compareTo(pracownik.getImie()) != 0)
            return Optional.ofNullable(imie).toString().compareTo(pracownik.getImie());
        return Optional.ofNullable(wiek).toString().compareTo(pracownik.getWiek());
    }

    @Override
    public String toString() {
        return "Praciwnik: imie: " + imie + " nazwisko: " + nazwisko + " wiek: " + wiek + ".";
    }


}
