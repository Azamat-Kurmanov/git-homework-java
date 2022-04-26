package ru.geekbrains.lesson_5;

public class MultiThread {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE/2;

    public static void main(String[] args) throws InterruptedException {
        float[] array = new float[SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }

        firstArrayMethod(array);
        secondArrayMethod(array);
    }

    public static void firstArrayMethod(float[] arr){
        long start = System.currentTimeMillis();
        initializingDataInArray(arr);
        System.out.println("Время выполнения 1 метода: " + (System.currentTimeMillis() - start)+" миллисекунд");
    }

    public static void secondArrayMethod(float[] arr) throws InterruptedException {
        float[] firstHalf = new float[HALF];
        float[] secondHalf = new float[HALF];
        float[] mergedArray = new float[SIZE];

        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, firstHalf, 0, HALF);
        System.arraycopy(arr, HALF, secondHalf, 0, HALF);

        Thread firstThread = new Thread(() -> {
            initializingDataInArray(firstHalf);
        });

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                initializingDataInArray(secondHalf);
            }
        });

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.arraycopy(firstHalf, 0, mergedArray, 0, HALF);
        System.arraycopy(secondHalf, 0, mergedArray, HALF, HALF);

        System.out.println("Время выполнения 2 метода: " + (System.currentTimeMillis() - start)+" миллисекунд");
    }

    public static float[] initializingDataInArray(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }
}
