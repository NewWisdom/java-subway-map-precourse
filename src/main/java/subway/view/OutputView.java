package subway.view;

import java.util.List;

public class OutputView {
    private static final String HEADER_SHARP = "## ";
    private static final String HEADER_INFO = "[INFO] ";
    private static final String INPUT_FUNCTION_INDEX_MESSAGE = "원하는 기능을 선택하세요.";
    private static final String INPUT_REGISTER_STATION_MESSAGE = "등록할 역 이름을 입력하세요.";
    private static final String REGISTER_STATION_SUCCESS = "지하철 역이 등록되었습니다.";
    private static final String INPUT_DELETE_STATION_MESSAGE = "삭제할 역 이름을 입력하세요.";
    private static final String INPUT_DELETE_STATION_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";

    public static void printFunctionTitle(String functionHeader) {
        System.out.println(HEADER_SHARP + functionHeader);
    }

    public static void printFunctionList(List<String> functionList) {
        for (String function : functionList) {
            System.out.println(function);
        }
        System.out.println();
    }

    public static void printInputFunctionIndex() {
        System.out.println(HEADER_SHARP + INPUT_FUNCTION_INDEX_MESSAGE);
    }

    public static void printInputRegisterStation() {
        System.out.println(HEADER_SHARP + INPUT_REGISTER_STATION_MESSAGE);
    }
    public static void printRegisterSuccess(){
        System.out.println();
        System.out.println(HEADER_INFO + REGISTER_STATION_SUCCESS);
        System.out.println();
    }
}
