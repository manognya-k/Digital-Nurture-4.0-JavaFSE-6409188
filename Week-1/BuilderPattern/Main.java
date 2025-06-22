public class Main {
    public static void main(String[] args) {

        Computer basicComputer = new Computer.Builder()
                                    .setCPU("Intel i5")
                                    .setRAM("8GB")
                                    .setStorage("256GB SSD")
                                    .build();

        basicComputer.showSpecs();

        Computer gamingComputer = new Computer.Builder()
                                    .setCPU("Intel i9")
                                    .setRAM("32GB")
                                    .setStorage("1TB SSD")
                                    .setGPU("NVIDIA RTX 4080")
                                    .build();

        gamingComputer.showSpecs();

        Computer budgetComputer = new Computer.Builder()
                                    .setCPU("AMD Ryzen 3")
                                    .setRAM("4GB")
                                    .build();

        budgetComputer.showSpecs();
    }
}
