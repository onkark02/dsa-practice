package practice.lld.oddeven.code.printer;

import practice.lld.oddeven.code.state.PrinterStateType;
import practice.lld.oddeven.code.state.State;

public class Printer implements Runnable{
    private final State state;
    private final PrinterStateType printerStateType;
    private final PrinterStateType nextPrinterStateType;
    private int currentValue;
    private final int stepSize;
    private final OutputPrinter outputPrinter;
    private final int maxValue;

    public Printer(State state, PrinterStateType printerStateType, PrinterStateType nextPrinterStateType, int startValue, int stepSize, OutputPrinter outputPrinter, int maxValue){
        this.state = state;
        this.printerStateType = printerStateType;
        this.nextPrinterStateType =nextPrinterStateType;
        this.currentValue = startValue;
        this.stepSize = stepSize;
        this.outputPrinter = outputPrinter;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        while (currentValue <= maxValue) {
            synchronized (state) {
                while (state.getPrinterStateType() != this.printerStateType) {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        outputPrinter.printMessage("Got interrupted");
                    }
                }
               // outputPrinter.printMessage("Current state: " + state.getPrinterStateType().toString());
                //outputPrinter.printMessage(this.printerStateType.toString() + ": " + currentValue);
                outputPrinter.printMessage(String.valueOf(currentValue));
                currentValue += stepSize;
                state.setPrinterStateType(this.nextPrinterStateType);
//                outputPrinter.printMessage("Set state to: " + state.getPrinterStateType().toString());
                state.notifyAll();
            }
        }
    }
}
