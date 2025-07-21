package com.xiaor.class_and_object.interface_;

public class Computer {
    public void work(UsbInterface usbInterface) {
        usbInterface.start();
        usbInterface.stop();
    }
}
