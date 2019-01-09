package optionalsExcercises;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Computer com=new Computer();
        Computer.SoundCard soundCard=com.new SoundCard();

        Computer.SoundCard.USB u =soundCard.new USB("3.0");   //-----------soundcard z usb
        Computer.SoundCard emptySoundCard= null;   //---------------pusta soundcard

        soundCard.setUsb(u);
        com.setSoundcard(soundCard);

        //soundCard.printUSB(usb);    // null pointer exception -> dalej zlapany
        soundCard.printUSB1();     // dziala git
        //emptySoundCard.mapTest();  //wywala NPE
        soundCard.mapTest();
        try{
            soundCard.checkIf3();
        }catch(MyException e){
        }

        Computer computer=new Computer(soundCard);   //---------------computer nie pustej soundcard
        computer.getSoundcard();
        computer.printSoundCard();


        try{
            soundCard.printUSB();
        }catch(NullPointerException n){
            System.out.println("puste USB");
        }

        String version = Optional.ofNullable(com)
                .flatMap(Computer::getSoundcard)
                .flatMap(Computer.SoundCard::getUsb)
                .map(Computer.SoundCard.USB::getVersion)
                .orElse("UNKNOWN");

        System.out.println("wersja znaleziona przez map:");
        System.out.println(version);
    }




}
