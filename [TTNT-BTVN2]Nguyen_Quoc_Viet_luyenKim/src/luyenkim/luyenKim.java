package luyenkim;

public class luyenKim {

    private wayOrder currentWay, nextWay;
    private int disTance, deltaDisTance;

    public int getDisTance() {
        return disTance;
    }

    public void setDisTance(int disTance) {
        this.disTance = disTance;
    }

    public int getDeltaDisTance() {
        return deltaDisTance;
    }

    public void setDeltaDisTance(int deltaDisTance) {
        this.deltaDisTance = deltaDisTance;
    }

    public wayOrder getCurrentWay() {
        return currentWay;
    }

    public void setCurrentWay(wayOrder currentWay) {
        this.currentWay = currentWay;
    }

    public wayOrder getNextWay() {
        return nextWay;
    }

    public void setNextWay(wayOrder nextWay) {
        this.nextWay = nextWay;
    }

    public luyenKim() {
        currentWay = new wayOrder();
        nextWay = new wayOrder();
        disTance = 0;
        deltaDisTance = 0;
    }

    public void start(int nhietDo) {
        int temperature = nhietDo;
        int deltaDistance = 0;
        // currentWay.scanWay();
        currentWay.loadWay();
        if (currentWay.getWay().size() < 3) {
            System.out.println("Đường đi chỉ có 2 điểm không thể luyện");
            return;
        }
        System.out.println("-------đường khởi tạo đầu tiên--------");// code mô phỏng
        currentWay.getTotalWay();// code mô phỏng
        currentWay.getSo().setReset(true);
        while (temperature > 0) {
            disTance = currentWay.getTotalDistance();
            nextWay = currentWay.getNetWayOrder();
            System.out.println("\n------lúc nhiệt độ còn[ " + temperature + " ]--------");// code mô phỏng
            System.out.print("đường đi hiện tại => ");// code mô phỏng
            currentWay.getTotalWay();// code mô phỏng
            System.out.println("Sẽ hoán vị ở vị trí: " + currentWay.swapIndex.show());// code mô phỏng
            System.out.print("đường đi tiếp theo => ");// code mô phỏng
            nextWay.getTotalWay();// code mô phỏng
            deltaDistance = disTance - nextWay.getTotalDistance();
            double exp = Math.exp(deltaDistance / (double) temperature);
            double alpha = Math.random();
            boolean ss1 = deltaDistance > 0;
            boolean ss2 = disTance > 0 && exp > alpha;
            if (ss1 || ss2) {
                currentWay.getWay().removeAll(currentWay.getWay());
                currentWay.getWay().addAll(0, nextWay.getWay());
                currentWay.getSo().setReset(true);
                if (ss1) {
                    System.out.println("* đường tiếp theo này có chi phí thấp hơn hiện tại");// code mô phỏng
                } else {
                    System.out.println("* exp= " + exp + " > alpha= " + alpha + "(chọn đường đi tiếp theo)");// code mô phỏng
                }
            } else {
                currentWay.getSo().setReset(false);
                System.out.println("* exp= " + exp + " < alpha= " + alpha + "(chọn đường đi hiện tại)");// code mô phỏng
            }
            temperature--;
            try {// code mô phỏng
                Thread.sleep(500);// code mô phỏng
            } catch (Exception e) {// code mô phỏng
                // TODO: handle exception// code mô phỏng
            }// code mô phỏng
        }
        System.out.println("\n=============đường đi chính thức===========");
        currentWay.getTotalWay();
    }

    // xác xuất tự chọn
    public void start(int nhietDo, double xacXuat) {
        int temperature = nhietDo;
        int deltaDistance = 0;
        double alpha = xacXuat;
        //currentWay.scanWay();
        currentWay.loadWay();
        if (currentWay.getWay().size() < 3) {
            System.out.println("Đường đi chỉ có 2 điểm không thể luyện");
            return;
        }
        System.out.println("-------đường khởi tạo đầu tiên--------");// code mô phỏng
        currentWay.getTotalWay();// code mô phỏng
        currentWay.getSo().setReset(true);
        while (temperature > 0) {
            disTance = currentWay.getTotalDistance();
            nextWay = currentWay.getNetWayOrder();
            System.out.println("\n------lúc nhiệt độ còn[ " + temperature + " ]--------");// code mô phỏng
            System.out.print("đường đi hiện tại => ");// code mô phỏng
            currentWay.getTotalWay();// code mô phỏng
            System.out.println("Sẽ hoán vị ở vị trí: " + currentWay.swapIndex.show());// code mô phỏng
            System.out.print("đường đi tiếp theo => ");// code mô phỏng
            nextWay.getTotalWay();// code mô phỏng
            deltaDistance = disTance - nextWay.getTotalDistance();
            double exp = Math.exp(deltaDistance / (double) temperature);
            //------double alpha = Math.random();
            boolean ss1 = deltaDistance > 0;
            boolean ss2 = disTance > 0 && exp > alpha;
            if (ss1 || ss2) {
                currentWay.getWay().removeAll(currentWay.getWay());
                currentWay.getWay().addAll(0, nextWay.getWay());
                currentWay.getSo().setReset(true);
                if (ss1) {
                    System.out.println("* đường tiếp theo này có chi phí thấp hơn hiện tại");// code mô phỏng
                } else {
                    System.out.println("* exp= " + exp + " > alpha= " + alpha + "(chọn đường đi tiếp theo)");// code mô phỏng
                }
            } else {
                currentWay.getSo().setReset(false);
                System.out.println("* exp= " + exp + " < alpha= " + alpha + "(chọn đường đi hiện tại)");// code mô phỏng
            }
            temperature--;
            try {// code mô phỏng
                Thread.sleep(200);// code mô phỏng
            } catch (Exception e) {// code mô phỏng
                // TODO: handle exception// code mô phỏng
            }// code mô phỏng
        }
        System.out.println("\n=============đường đi chính thức===========");
        currentWay.getTotalWay();
    }
}
