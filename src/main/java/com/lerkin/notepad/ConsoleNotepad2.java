package com.lerkin.notepad;

import java.util.Scanner;

public class ConsoleNotepad2 {
    private final static String ADD_NOTE = "add";
    private final static String REMOVE_NOTE = "remove";
    private final static String VIEW_NOTES = "view";
    private static Scanner scanner = new Scanner(System.in);
    private static Notepad notepad = new Notepad(4);

    public static void main(String[] args) {
        System.out.println("Hi");

        while (true) {
            System.out.println("\n\n???????????");
            System.out.println(ADD_NOTE);
            System.out.println(REMOVE_NOTE);
            System.out.println(VIEW_NOTES);
            System.out.println("???????????\n\n");

            String command = scanner.nextLine();

            switch (command) {
                case VIEW_NOTES:
                    System.out.println(notepad);
                    break;
                case ADD_NOTE:
                    if (notepad.isFull()) {
                        System.out.println("Notepad is full. Need more space to add new note");
                    } else {
                        System.out.print("Title: ");
                        String title = getNotEmptyStringFromConsole();
                        System.out.print("\nDescription: ");
                        String description = getNotEmptyStringFromConsole();
                        Note newNote = new Note(title, description);
                        notepad.addNote(newNote);
                    }
                    break;
                case REMOVE_NOTE:
                    if (notepad.isEmpty()) {
                        System.out.println("Notepad is already empty");
                    } else {
                        System.out.println(notepad);
                        System.out.println("Which one u want to remove?");
                        int indexToRemove = scanner.nextInt();
                        while (indexToRemove <= 0 || indexToRemove > notepad.getLastInsertIndex() + 1) {
                            System.out.println("Enter valid note number");
                            indexToRemove = scanner.nextInt();
                        }
                        indexToRemove--;
                        notepad.removeNote(indexToRemove);
                        System.out.println(notepad);
                    }
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }



    private static String getNotEmptyStringFromConsole() {
        String input = scanner.nextLine();
        while (input.trim().isEmpty()) {
            input = scanner.nextLine();
        }
        return input;
    }

}
