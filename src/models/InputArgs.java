package models;

public class InputArgs {
    private String inputFile;
    private String outputFile;

    public InputArgs(String[] args) {
        parseArgs(args);
    }

    private void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i":
                    if (i + 1 < args.length) {
                        inputFile = args[++i];
                    }
                    break;
                case "-o":
                    if (i + 1 < args.length) {
                        outputFile = args[++i];
                    }
                    break;
            }
        }

        if (inputFile == null) {
            throw new IllegalArgumentException("Не указан входной файл. Используйте -i <filename>");
        }
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public boolean hasOutputFile() {
        return outputFile != null && !outputFile.isEmpty();
    }
}