package com.spa;

public class RandonneVelo {
    public static void main(String[] args) {
        String line;
        // Scanner sc = new Scanner(System.in);
        // while (sc.hasNextLine()) {
        // line = sc.nextLine();
        var result = compute(new int[]{1, 2, 2, 3, 5, 7, 3, 1, 1, 4, 3, 6});
        System.out.println(result.nbMontantes + " " + result.nbDescendantes);
        /* Lisez les données et effectuez votre traitement */
        // }

        // sc.close();
    }

    private static int[] convertToInts(String[] args) {
        int[] results = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            results[i] = Integer.parseInt(args[i]);
        }
        return results;
    }

    public record Result(int nbMontantes, int nbDescendantes) {

    }

    private static Result compute(int[] parcours) {
        int previous = parcours[0];
        int current = parcours[1];
        boolean up = (current - previous) > 0;
        boolean down = (current - previous) < 0;
        int nbMontantes = up ? 1 : 0;
        int nbDescendantes = down ? 1 : 0;
        System.err.println("Hello" + nbMontantes + " " + nbDescendantes);
        for (int index = 2; index < parcours.length; index++) {
            boolean newUp = (parcours[index] - parcours[index - 1]) > 0;
            boolean newDown = (parcours[index] - parcours[index - 1]) < 0;
            if (newUp && !up) {
                up = newUp;
                System.err.println("Montantes " + parcours[index] + " " + parcours[index - 1]);
                nbMontantes++;
            }
            if (up && !newUp) {
                up = false;
            }

            if (newDown && !down) {
                down = newDown;
                nbDescendantes++;
            }

            if (down && !newDown) {
                down = false;
            }
        }
        return new Result(nbMontantes, nbDescendantes);
    }

}
