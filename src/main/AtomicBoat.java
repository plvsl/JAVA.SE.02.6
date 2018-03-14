package main;

public class AtomicBoat {

    private AtomicBoatEngine atomicBoatEngine;
    private int oil;

    public AtomicBoat(int oil) {
        atomicBoatEngine = new AtomicBoatEngine();
        this.oil = oil;
    }

    private class AtomicBoatEngine {

        private boolean isStarted = false;

        private void turnOn() {
            isStarted = true;
        }

        private void turnOff() {
            isStarted = false;
        }

        private String start(int miles) throws UnsupportedOperationException {
            StringBuilder way = new StringBuilder();
            if (!isStarted) {
                throw new UnsupportedOperationException("Atomic boats engine is not started");
            } else {
                while (oil > 0 && miles > 0) {
                    oil--;
                    miles--;
                    way.append("we are going, ");
                }
                if (oil <= 0)
                    way.append("oil is over");
                return way.toString();
            }
        }
    }

    public boolean isEngineStarted() {
        return atomicBoatEngine.isStarted;
    }

    public void startEngine() {
        atomicBoatEngine.turnOn();
    }

    public void stopEngine() {
        atomicBoatEngine.turnOff();
    }

    public String go(int miles) throws UnsupportedOperationException {
        return atomicBoatEngine.start(miles);
    }

    public static void main(String[] args) {
        AtomicBoat atomicBoat = new AtomicBoat(100);
        atomicBoat.startEngine();
        atomicBoat.go(5);
    }

}
