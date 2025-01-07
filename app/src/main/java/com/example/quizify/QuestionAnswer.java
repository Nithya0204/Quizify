package com.example.quizify;

public class QuestionAnswer {
    public static String question[] = {
            "Which company owns the android?",
            "Which one is not the programming language?",
            "What is APK in Android?",
            "Identify the language on which Android is based on?",
            "All layout classes are the subclasses of?",
            "While developing android application developers can test their apps on?",
            "In android, mini activities are also known as?"

    };

    public static String choices[][] = {
            {"Google", "Apple", "Nokia", "Samsung"},
            {"java", "Kotlin", "Notepad", "Python"},
            {"Android packages", "Android pack", "Android Packaging Kit", "None of the Above"},
            {"Python","C++","Java","None"},
            {"android.widget","android.view.View","android.view.ViewGroup","None"},
            {"Emulators in Android SDK","Android Phone","Third-Party emulator","All of the above"},
            {"Adapter","Activity","Fragments","None"}

    };

    public static String correctAnswers[] = {
            "Google",
            "Notepad",
            "Android Packaging Kit",
            "Java",
            "android.view.ViewGroup",
            "All of the above",
            "Fragments"
    };
    public static String questions2[]={

            "Which media format is not supported  by Android?",
            "In which directory XML layout files are stored?",
            "Which code is used by Android is not a open source?",
            "How many levels of securities are in Android?"
    };
    public static String choices2[][] = {

            {"MP4","AVI","MIDI","MPEG"},
            {"/assets","/src","/res/values","/res/layout"},
            {"Video Driver","Wifi Driver","Device Driver","Bluetooth Driver"},
            {"Android level security","App and Kernel level security","Java level security","None of the above"}
    };
    public static String correctanswers2[]={
            "AVI",
            "/res/layout",
            "Wifi Driver",
            "App and Kernel level security"
    };
}
