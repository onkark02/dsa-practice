package practice.lld.oddeven.code;

import practice.lld.oddeven.code.printer.OutputPrinter;
import practice.lld.oddeven.code.printer.Printer;
import practice.lld.oddeven.code.state.PrinterStateType;
import practice.lld.oddeven.code.state.State;

public class Tester {
    public static void main(String[] args) {
        final State state = new State(PrinterStateType.REM_1);
        OutputPrinter outputPrinter = new OutputPrinter();
        int maxValue = 100000;
        Printer rem1 = new Printer(state,PrinterStateType.REM_1,PrinterStateType.REM_2,1,4,outputPrinter,maxValue);
        Printer rem2 = new Printer(state,PrinterStateType.REM_2,PrinterStateType.REM_3,2,4,outputPrinter,maxValue);
        Printer rem3 = new Printer(state,PrinterStateType.REM_3,PrinterStateType.REM_0,3,4,outputPrinter,maxValue);
        Printer rem4 = new Printer(state,PrinterStateType.REM_0,PrinterStateType.REM_1,4,4,outputPrinter,maxValue);

        Thread thread1 = new Thread(rem1);
        thread1.setName("rem-1");
        Thread thread2 = new Thread(rem2);
        thread2.setName("rem-2");
        Thread thread3 = new Thread(rem3);
        thread3.setName("rem-3");
        Thread thread4 = new Thread(rem4);
        thread4.setName("rem-0");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
