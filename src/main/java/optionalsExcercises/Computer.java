package optionalsExcercises;

import java.util.Optional;


public class Computer {

    private SoundCard soundcard;

    public Computer() {
    }

    public Computer(SoundCard soundcard) {
        this.soundcard = soundcard;
    }

    public void printSoundCard() {
        Optional.ofNullable(this.soundcard).ifPresent(n -> System.out.println("Soundcard"));
    }

    public Optional<SoundCard> getSoundcard() {
        //Optional.ofNullable(this.soundcard).ifPresent(n -> printSoundCard());
        return Optional.ofNullable(soundcard);
    }

    public void setSoundcard(SoundCard soundcard) {
        this.soundcard = soundcard;
    }
//----------------------------------------------------------------------klasa wewnetrzna  SOUNDCARD


    public class SoundCard {
        private USB usb;
        //private List<USB> usbList=new ArrayList<>();

        public SoundCard() {
        }

        public SoundCard(USB usb) {
            this.usb = usb;
        }

        public void printUSB() {
            System.out.println(usb.getVersion());
        }

        public void printUSB1() {
            Optional.ofNullable(usb).ifPresent(n -> System.out.println(usb.getVersion()));
        }

        public void checkIf3() throws MyException {
            Optional.ofNullable(usb).filter(u -> "3.0".equals(usb.getVersion())).orElseThrow(MyException::new);
        }

        public Optional<USB> getUsb() {

            return Optional.ofNullable(usb);
        }

//        public List<USB> getUsbList() {
//            return usbList;
//        }

        public void setUsb(USB usb) {
            this.usb = usb;
        }

        public void mapTest() {
            //     Optional.of(this).map(SoundCard::getUsb).filter(n->"3.0".equals(usb.getVersion())).ifPresent(m->System.out.println("ok"));   //wywali NPE
            Optional.ofNullable(this).map(SoundCard::getUsb).filter(n -> "3.0".equals(usb.getVersion())).ifPresent(m -> System.out.println("ok"));   // tez wywali

        }

        //---------------------------------------------------------------------klasa wewnetrzna USB


        public class USB {
            private String version = "";

            public USB() {
            }

            public USB(String version) {
                this.version = version;
            }

            public String getVersion() {
                return version;
            }

        }

    }
}

