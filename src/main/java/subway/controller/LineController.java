package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.Function;
import subway.view.resource.Screen;

public class LineController {
    public void run(InputView inputView) {
        OutputView.printTitle(Screen.LINE.getTitle());
        OutputView.printFunctionList(Screen.LINE.getFunctionList());
        OutputView.printInputFunctionIndex();
        callFunction(inputView, inputView.getInputFunctionIndex(Screen.LINE.getIndexList()));
    }

    private void callFunction(InputView inputView, String functionIndex) {
        if (functionIndex.equals(Function.REGISTER.getIndex())) {
            registerLine(inputView);
        }
        if (functionIndex.equals(Function.DELETE.getIndex())) {
            deleteLine(inputView);
        }
        if (functionIndex.equals(Function.LOOKUP.getIndex())) {
            lookUpLine(inputView);
        }
        if (functionIndex.equals(Function.BACK.getIndex())) {
            goBackToMain(inputView);
        }
    }

    private void registerLine(InputView inputView) {
        OutputView.printInputRegisterValue(Screen.LINE.getName());
        Line line = new Line(inputView.getInputRegisterLine());
        LineRepository.addLine(line);
        registerSection(inputView, line);
        OutputView.printRegisterSuccess(Screen.LINE.getName());
        goBackToMain(inputView);
    }

    private void deleteLine(InputView inputView) {
        OutputView.printInputDeleteValue(Screen.LINE.getName());
        if (LineRepository.deleteLineByName(inputView.getInputDeleteLine())) {
            OutputView.printDeleteSuccess(Screen.LINE.getName());
        }
        goBackToMain(inputView);
    }

    private void lookUpLine(InputView inputView) {
        OutputView.printListTitle(Screen.LINE.getName());
        for (Line line : LineRepository.lines()) {
            System.out.println(line);
        }
        goBackToMain(inputView);
    }

    private void goBackToMain(InputView inputView) {
        MainController.run(inputView);
    }

    private void registerSection(InputView inputView, Line line) {
        OutputView.printRegisterFirstStation();
        String firstStation = inputView.getInputRegisterFirstStation(line.getName());
        OutputView.printRegisterLastStation();
        String lastStation = inputView.getInputRegisterLastStation(firstStation, line.getName());
        SectionRepository.addSection(line.getName(), firstStation, lastStation);
    }
}


