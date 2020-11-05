package _20201102;

class Usb {
    public void turnOn() {

    }
    public void turnOff() {

    }
}

class Mouse extends Usb {
    @Override
    public void turnOn() {
        System.out.println("mouse is on");
    }

    @Override
    public void turnOff() {
        System.out.println("mouse is off");
    }
}

class mic extends Usb {
    @Override
    public void turnOn() {
        System.out.println("mic is on");
    }

    @Override
    public void turnOff() {
        System.out.println("mic is off");
    }
}

class computer {
    Usb[] usbDevice = new Usb[4];
    public void addUsb(Usb u) {
        for (int i = 0; i < usbDevice.length; i++) {
            if (usbDevice[i] == null) {
                usbDevice[i] = u;
                break;
            }
        }
    }
    public void turnOn() {
        System.out.println("computer is on");
        for (int i = 0; i < usbDevice.length; i++) {
            if (usbDevice[i] != null) {
                usbDevice[i].turnOn();
            }
        }
        System.out.println("all devices in computer is on");
    }
    public void turnOff() {
        System.out.println("computer is off");
        for (int i = 0; i < usbDevice.length; i++) {
            if (usbDevice[i] != null) {
                usbDevice[i].turnOff();
            }
        }
        System.out.println("all devices in computer is off");
    }
}

public class TestCastUp {
    public static void main(String[] args) {
        //构造方法存在的意义是给对象初始化
        Usb u1 = new Mouse();
        Usb u2 = new mic();
        computer cmp = new computer();
        cmp.addUsb(u1);
        cmp.turnOn();
        cmp.addUsb(u2);
        cmp.turnOn();
        //cmp.turnOff();
    }
}
