package practice.lld.oddeven.code.state;

public class State {
    private PrinterStateType printerStateType;

    public State(PrinterStateType printerStateType){
        this.printerStateType = printerStateType;
    }

    public PrinterStateType getPrinterStateType(){
        return this.printerStateType;
    }

    public void setPrinterStateType(PrinterStateType printerStateType) {
        this.printerStateType = printerStateType;
    }
}
