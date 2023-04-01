package com.spa.hackerrank;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {

    static class Operation {
        OperationType operationType;
        Integer operand1;
        Integer operand2;

        public Operation(OperationType operationType, Integer operand1, Integer operand2) {
            this.operationType = operationType;
            this.operand1 = operand1;
            this.operand2 = operand2;
        }

        public OperationType getOperationType() {
            return operationType;
        }

        public Integer getOperand1() {
            return operand1;
        }

        public Integer getOperand2() {
            return operand2;
        }
    }

    enum OperationType {
        AND, OR, XOR, FLIP, SET
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine();
        BitSet b1 = new BitSet(a);
        BitSet b2 = new BitSet(a);
        while (scanner.hasNext()) {
            Operation operation = readOperation(scanner.nextLine());
            switch (operation.getOperationType()) {
                case OR:
                    if (operation.getOperand1() == 1) {
                        b1.or(b2);
                    } else {
                        b2.or(b1);
                    }
                    break;
                case AND:
                    if (operation.getOperand1() == 1) {
                        b1.and(b2);
                    } else {
                        b2.and(b1);
                    }
                    break;

                case XOR:
                    if (operation.getOperand1() == 1) {
                        b1.xor(b2);
                    } else {
                        b2.xor(b1);
                    }
                    break;

                case FLIP:
                    if (operation.getOperand1() == 1) {
                        b1.flip(operation.getOperand2());
                    } else {
                        b2.flip(operation.getOperand2());
                    }
                    break;
                case SET:
                    if (operation.getOperand1() == 1) {
                        b1.set(operation.getOperand2());
                    } else {
                        b2.set(operation.getOperand2());
                    }
                    break;

            }
            System.out.printf("%d %d\n", b1.cardinality(), b2.cardinality());
        }
    }

    public static Operation readOperation(String operationLine) {
        String[] tokens = operationLine.split("\\s+");
        switch (tokens[0]) {
            case "AND":
                return new Operation(OperationType.AND, Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[2]));
            case "OR":
                return new Operation(OperationType.OR, Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[2]));
            case "XOR":
                return new Operation(OperationType.XOR, Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[2]));
            case "FLIP":
                return new Operation(OperationType.FLIP, Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[2]));
            case "SET":
                return new Operation(OperationType.SET, Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[2]));
            default:
                throw new UnsupportedOperationException();
        }
    }
}
