import java.lang.String;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("You should write one parameter!");
            return;
        }

        try {
            if (args.length > 1) {
                System.out.println("You are allowed to write only one parameter!");
                return;
            } else {
                char[] symbols = args[0].toCharArray();
                String[] num_array = new String[symbols.length];
                boolean flag = false;
                boolean minus = false;
                int num = 0;
                int index = 0;

                for (int i = 0; i < symbols.length; i++)
                    num_array[i] = "";

                for (int i = 0; i < (symbols.length - 1); i++) {
                    if (((symbols[i + 1] >= '0') && (symbols[i + 1] <= '9')) && (symbols[i] == '-')) {
                        minus = true;
                    }

                    if (!((symbols[i + 1] >= '0') && (symbols[i + 1] <= '9')) && (symbols[i] == '-')) {
                        minus = false;
                    }

                    if (!((symbols[i] >= '0') && (symbols[i] <= '9')) && !(symbols[i] == '-')) {
                        minus = false;
                    }

                    if ((symbols[i] >= '0') && (symbols[i] <= '9') && !(minus)) {
                        flag = true;
                        num_array[index] += symbols[i];
                        if ((i == (symbols.length - 2)) && ((symbols[i + 1] >= '0') && (symbols[i + 1] <= '9'))) {
                            num = 1;
                        }
                    } else {
                        if (flag) {
                            index++;
                            flag = false;
                        } else {
                            continue;
                        }
                    }
                }
                System.out.println(num);
                System.out.println(minus);

                index++;

                if (num == 1) {
                    num_array[index - 1] += symbols[symbols.length - 1];
                } else {
                    if ((symbols[symbols.length - 1] >= '0') && (symbols[symbols.length - 1] <= '9') && (minus == false)) {
                        num_array[index-1] = "0" + symbols[symbols.length - 1];
                    }
                }

                if ((index == 1) && (num_array[index-1] == "")) {
                    System.out.println("There aren't non-positive numbers!");
                    return;
                }

                System.out.println(index);
                System.out.println(num_array[index]);
                if ((index == 2) && (num_array[index-1] == ""))
                {
                    index--;
                }

                if (num_array[index-1] == "") {
                    index--;
                }
                int numbers[] = new int[index];
                System.out.println(num_array[index]);
                for (int i = 0; i < index; i++) {
                    numbers[i] = Integer.parseInt(num_array[i]);
                }

                int temp;
                for (int i = 0; i < index; i++) {
                    for (int j = 0; j < index; j++)
                        if (numbers[i] < numbers[j]) {
                            temp = numbers[i];
                            numbers[i] = numbers[j];
                            numbers[j] = temp;
                        }
                }

                System.out.println("String as the paramater - " + args[0]);

                System.out.println("Numbers founded in this string:");
                for (int i = 0; i < index; i++) {
                    System.out.println((i + 1) + ": " + num_array[i]);
                }


                System.out.println("Sorted numbers: ");
                for (int i = 0; i < index; i++) {
                    System.out.println((i + 1) + ": " + numbers[i]);
                }
            }
    }catch(NumberFormatException err) {
            System.out.println("NumberFormatException: " + err.getMessage());
        }
    }
}


