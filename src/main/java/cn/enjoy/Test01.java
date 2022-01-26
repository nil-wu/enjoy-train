package cn.enjoy;

public class Test01 {

    private static class UseThread implements Runnable{

        @Override
        public void run() {
            try {
                Process process = Runtime.getRuntime().exec("F:\\download\\BQ2__Display_Pilot_2.2.08.0_RC3-DisplayPilot.exe") ;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public static void getHaha(){

    }

    public static void main(String[] args) throws Exception{
        for (int i = 0; i <10 ; i++) {
            Thread t = new Thread(new UseThread());
            t.start();
//            Process process = Runtime.getRuntime().exec("F:\\download\\intellj2021.2.3\\intellj2021.2.3\\ideaIU-2021.2.3.exe");
        }
//        Process process = Runtime.getRuntime().exec("F:\\download\\intellj2021.2.3\\intellj2021.2.3\\ideaIU-2021.2.3.exe");
//        Process process = Runtime.getRuntime().exec("msiexec /i \"H:\\Users\\wuhaopeng\\Pictures\\mysql-workbench-community-8.0.27-winx64.msi");

    }
}
