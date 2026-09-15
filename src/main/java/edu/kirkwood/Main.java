package edu.kirkwood;

import edu.kirkwood.view.MainMenu;

import static edu.kirkwood.view.Messages.goodbye;
import static edu.kirkwood.view.Messages.hello;

public class Main {
    static void main() {
        hello();
        MainMenu.show();
        goodbye();
    }
}
