package com.lerkin.notepad;

import java.util.Scanner;

public class ConsoleNotepad {
    private final static String ADD_NOTE = "add";
    private final static String REMOVE_NOTE = "remove";
    private final static String VIEW_NOTES = "view";
    private static Scanner scanner = new Scanner(System.in);
    private static Note[] notes = new Note[10];

    public static void main(String[] args) {
        System.out.println("Hi");
        int lastInsert = -1;

        while (true) {
            System.out.println("\n\n???????????");
            System.out.println(ADD_NOTE);
            System.out.println(REMOVE_NOTE);
            System.out.println(VIEW_NOTES);
            System.out.println("???????????\n\n");

            String command = scanner.nextLine();

            switch (command) {
                case VIEW_NOTES:
                    for (int i = 0; i < notes.length; i++) {
                        if (notes[i] != null) {
                            System.out.println(notes[i]);
                        } else {
                            break;
                        }
                    }
                    break;
                case ADD_NOTE:
                    if (lastInsert == notes.length - 1) {
                        System.out.println("Notepad is full. Need more space to add new note");
                    } else {
                        System.out.print("Title: ");
                        String title = getNotEmptyStringFromConsole();
                        System.out.print("\nDescription: ");
                        String description = getNotEmptyStringFromConsole();
                        Note newNote = new Note(title, description);
                        notes[++lastInsert] = newNote;
                    }
                    break;
                case REMOVE_NOTE:
                    if (lastInsert < 0) {
                        System.out.println("Notepad is already empty");
                    } else {
                        printNotes();
                        System.out.println("Which one u want to remove?");
                        int indexToRemove = scanner.nextInt();
                        while (indexToRemove < 0 || indexToRemove > lastInsert + 1) {
                            System.out.println("Enter valid note number");
                            indexToRemove = scanner.nextInt();
                        }
                        indexToRemove--;
                        notes[indexToRemove] = null;
                        for (int i = indexToRemove; i < lastInsert; i++) {
                            Note temp = notes[i];
                            notes[i] = notes[i + 1];
                            notes[i + 1] = temp;
                        }
                        printNotes();
                    }
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    private static void printNotes() {
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] != null) {
                System.out.println((i + 1) + ". " + notes[i]);
            } else {
                break;
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
