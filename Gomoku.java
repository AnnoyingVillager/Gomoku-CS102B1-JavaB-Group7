import java.awt.*;
import java.awt.event.InputEvent;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.TimerTask;
import java.util.Timer;

public final class Gomoku {
	private static int windowsStatus = 0;
	// startWindows = 0 ; gameWindows = 1 ; gamePauseWindows = 2 ; settingWindows = 3 ; noSavesWindows = 4 ; exitSaveReminder = 5; winnerWindows = 6;
	private static boolean isGamePause = false;//for Timer
	private static int x;
	private static int y;
	private static int broadSize = 15;
	private static double stepLength = 504/14.0;
	private static double mouseX;
	private static double mouseY;
	public static int color;
	public static int tempX = 0;
	public static int tempY = 0;
	public static int lastX = 0;
	public static int lastY = 0;
	public static int winnerColor = 0;
	public static boolean enableForbidden = true;
	public static boolean isSaved = false;
	public static boolean isGaming = false;
	public static boolean isFromGameWindows = false;
	public static boolean isFromGamePauseWindows = false;
	public static boolean isFromBackToMenu = false;
	public static boolean isFromExit = false;
	public static boolean isWin = false;
	public static boolean isPlayerDrawn = false;
	public static boolean isCleared = true;
	public static boolean isDrawn = false;
	public static boolean isTimerDrawn = false;
	public static boolean isTitleDrawn = true;
	public static boolean isMachine = false;

	public static int getBroadSize() {
		return broadSize;
	}

	public static void main(String[] args) throws AWTException, InterruptedException {
		GUI startWindows = new GUI(540, 720);
		GUI gameWindows = new GUI(1280, 720);
		GUI settingWindows = new GUI(540,720);
		GUI noSavesWindows = new GUI(450,250);
		GUI exitSaveReminder = new GUI(450,250);
		GUI winnerWindows = new GUI(1280,720);

		ChessBoard board = new ChessBoard(15);
		StdDraw.enableDoubleBuffering();

		startWindows.generateStartWindows();
		startWindows.drawStart();
		StdDraw.show();
		TimerPlus timer1 = new TimerPlus(1280, 720, 28, 0);
		TimerPlus timer2 = new TimerPlus(1280, 720, 28, 1);
		final Thread[] thread1 = {new Thread(timer1)};
		final Thread[] thread2 = {new Thread(timer2)};
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//鼠标监听线程段开始
		Timer mouse = new Timer();
		mouse.schedule(new TimerTask() {
			@Override
			public void run() {
				mouseX = StdDraw.mouseX();
				mouseY = StdDraw.mouseY();
				color = board.getMoveTimes() % 2 + 1;
				//System.out.println(mouseX+" "+mouseY+"    ");
				if(!isMachine || !(board.getMoveTimes() % 2 == 1) || isWin) {
					switch (windowsStatus){
						// startWindows = 0 ; gameWindows = 1 ; gamePauseWindows = 2 ; settingWindows = 3 ; noSavesWindows = 4 ; exitSaveReminder = 5;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// StartWindows
						case 0:
							if(!isCleared) {
								startWindows.drawStart();
								isCleared = true;
							}
							if(!timer1.isPaused() || !timer2.isPaused()) {
								timer1.reset();
								timer2.reset();
								thread1[0].interrupt();
								thread2[0].interrupt();
							}
							//Button 01
							if (93<mouseX && mouseX<456  &&  473<mouseY && mouseY<537){
								if(!isDrawn) {
									startWindows.drawStartPress(1);
									isDrawn = true;
								}

								if (StdDraw.isMousePressed()){
									//Button 01 Command
									isMachine = false;
									gameWindows.generateGameWindows();
									if (StdDraw.isMousePressed()){
										try {
											mouseReset();
										} catch (AWTException e) {
											e.printStackTrace();
										}
									}
									board.initializeBoard();
									gameWindows.drawCanvas();
									gameWindows.drawMenuPause();
									windowsStatus = 2;
									isGaming = false;
									isSaved = true;
								}
							}
							else {

								//Button 02
								if (93<mouseX &&mouseX<456  &&  362<mouseY && mouseY<426){
									if(!isDrawn) {
										startWindows.drawStartPress(2);
										isDrawn = true;
									}

									if (StdDraw.isMousePressed()){
										try {
											isMachine = false;
											Thread.sleep(500);
											board.load();
											isWin = false;
											color = board.getMoveTimes() % 2 + 1;
											board.initializeSteps();
											timer1.reset();
											timer2.reset();
											timer1.setTimeSpent(board.getTimeSpent());
											timer2.setTimeLeft(board.getTimeLeft());
											gameWindows.generateGameWindows();
											isSaved = true;
											// if (StdDraw.isMousePressed()){
											// 	try {
											// 		mouseReset();
											// 	} catch (AWTException e) {
											// 		e.printStackTrace();
											// 	}
											// }
											gameWindows.drawCanvas();
											gameWindows.drawMenuPause();
											windowsStatus = 2;
											isGaming = false;
										} catch (FileNotFoundException e1) {
											if (StdDraw.isMousePressed()){
												try {
													mouseReset();
												} catch (AWTException e) {
													e.printStackTrace();
												}
											}
											noSavesWindows.generateNoSavesWindows();
											noSavesWindows.drawNoSaves();
											if (StdDraw.isMousePressed()){
												try {
													mouseReset();
												} catch (AWTException e) {
													e.printStackTrace();
												}
											}
											windowsStatus = 4;
											isGaming = false;
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
										System.out.println("Button 02 is CLICKED");
										if (StdDraw.isMousePressed()){
											try {
												mouseReset();
											} catch (AWTException e) {
												e.printStackTrace();
											}
										}
									}
								}else {
									//Button 03
									if (93<mouseX &&mouseX<456  &&  259<mouseY && mouseY<318){
										if(!isDrawn) {
											startWindows.drawStartPress(3);
											isDrawn = true;
										}

										if (StdDraw.isMousePressed()){
											//Button 03 Command
											windowsStatus = 2;
											board.initializeBoard();
											isMachine = true;
											gameWindows.generateGameWindows();
											gameWindows.drawCanvas();
											gameWindows.drawMenu();
											System.out.println("Button 03 is CLICKED");
											System.out.println("This function is under developing.");
											if (StdDraw.isMousePressed()){
												try {
													mouseReset();
												} catch (AWTException e) {
													e.printStackTrace();
												}
											}
										}
									}else {

										//Button 04
										if (93<mouseX &&mouseX<253  &&  150<mouseY && mouseY<210){
											if(!isDrawn) {
												startWindows.drawStartPress(4);
												isDrawn = true;
											}

											if (StdDraw.isMousePressed()){
												//Button 04 Command
												settingWindows.drawOptions();
												if (StdDraw.isMousePressed()){
													try {
														mouseReset();
													} catch (AWTException e) {
														e.printStackTrace();
													}
												}
												windowsStatus = 3;
												isGaming = false;
											}
										}else {

											//Button 05
											if (290<mouseX &&mouseX<456  &&  150<mouseY && mouseY<210){
												if(!isDrawn) {
													startWindows.drawStartPress(5);
													isDrawn = true;
												}

												if (StdDraw.isMousePressed()){
													//Button 05 Command
													System.exit(0);
												}
											}else {
												if(isDrawn) {
													startWindows.drawStart(1);
													startWindows.drawStart(2);
													startWindows.drawStart(3);
													startWindows.drawStart(4);
													startWindows.drawStart(5);
													isDrawn = false;
												}
											}
										}
									}
								}
							}
							break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// GameWindows
						case 1:
							if(TimerPlus.isEnd()) {
								isGaming = false;
								if (color == 1) {
									winnerColor = 2;
								}else {
									if (color == 2){
										winnerColor = 1;
									}else {
										winnerColor = 0;
									}
								}
								try {
									System.out.println(winnerColor);
									winnerWindows.drawMenuWin(winnerColor);
									winnerWindows.drawMenuWinTitle(winnerColor);
									winnerWindows.drawMenuWin(winnerColor);
									winnerWindows.drawMenuWinTitle(winnerColor);
									winnerWindows.drawMenuWin(winnerColor);
									winnerWindows.drawMenuWinTitle(winnerColor);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								windowsStatus = 6;
							}
							else {
								if(thread1[0] == null) {
									thread1[0] = new Thread(timer1);
								}
								if(thread2[0] == null) {
									thread2[0] = new Thread(timer2);
								}
								if(thread1[0].getState() == Thread.State.TERMINATED) {
									thread1[0] = new Thread(timer1);
								}
								if(thread2[0].getState() == Thread.State.TERMINATED) {
									thread2[0] = new Thread(timer2);
								}
								if(!timer1.isStarted()) {
									timer1.startedOrContinue();
								}
								if(!timer2.isStarted()) {
									timer2.startedOrContinue();
								}
								if(thread1[0].getState() == Thread.State.NEW) {
									thread1[0].start();
									timer1.setStart(true);
								}
								if(thread2[0].getState() == Thread.State.NEW) {
									thread2[0].start();
									timer2.setStart(true);
								}
							}
							if(!isPlayerDrawn) {
								if(!isWin) {
									try {
										Thread.sleep(200);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									gameWindows.drawPlayer(board.getMoveTimes() % 2 == 0);
									gameWindows.drawPlayer(board.getMoveTimes() % 2 == 0);
								}
								isPlayerDrawn = true;
							}
							//拟落子位置显示及落子步骤
							if (mouseX<700 && isGaming){
								x = toChessGridX(mouseX);
								y = toChessGridY(mouseY);
								//拟落子位置显示
								if ((board.getMoveTimes() + 1) % 2 != 0){
									color = 1;
								}else {
									color = 2;
								}
								if (x != tempX || y!=tempY){
									tempX = x;
									tempY = y;
									//System.out.println("change  "+"  lastX:" +lastX+"  |lastY:"+lastY+"\n tempX:"+tempX+"  |tempY"+tempY+"\n           X:"+x+"  |Y"+y);
									gameWindows.drawFakeChess(x,y,color);
									gameWindows.drawChessReverse(lastX,lastY);
									lastX = tempX;
									lastY = tempY;
									GUI.isChessDrawn = false;
									if(!isTitleDrawn) {
										StdDraw.setPenColor(235,245,255);
										StdDraw.filledRectangle(1024, 612, 200, 50);
										GUI.drawTitle(1024, 612, 30, "Gomoku Game");
										isTitleDrawn = true;
									}
								}
							}
							else {
								if(GUI.isChessDrawn) {
									gameWindows.drawChessReverse(lastX,lastY);
									GUI.isChessDrawn = false;
								}
								//按钮01
								if (844<mouseX &&mouseX<1204  &&  473<mouseY && mouseY<537){
									if(!isDrawn) {
										gameWindows.drawMenuPress(1);
										isDrawn = true;
									}

									if (StdDraw.isMousePressed()){
										//Button 01 Command
										gameWindows.drawMenuPause();
										windowsStatus = 2;
										isGaming = false;
										if (StdDraw.isMousePressed()){
											try {
												mouseReset();
											} catch (AWTException e) {
												e.printStackTrace();
											}
										}
									}
								}
								else {
									//按钮02
									if (844<mouseX &&mouseX<1204  &&  362<mouseY && mouseY<426){
										//gameWindows.drawMenuPress(2);
										//gameWindows.drawMenu(1);
										//gameWindows.drawMenu(3);
										//gameWindows.drawMenu(4);
										//gameWindows.drawMenu(5);
										//if (StdDraw.isMousePressed()){
										//	//Button 02 Command
										//	System.out.println("Button 02 is CLICKED");
										//	try {
										//		board.setTimeSpent(timer1.getTimeSpent());
										//		board.setTimeLeft(timer2.getTimeLeft());
										//		board.save();
										//		isSaved = true;
										//	} catch (FileNotFoundException e) {
										//		e.printStackTrace();
										//	}
										//	if (StdDraw.isMousePressed()){
										//		try {
										//			mouseReset();
										//		} catch (AWTException e) {
										//			e.printStackTrace();
										//		}
										//	}
										//}
									}else {

										//按钮03
										if (844<mouseX &&mouseX<1204  &&  259<mouseY && mouseY<318){
											if(!isDrawn) {
												gameWindows.drawMenuPress(3);
												isDrawn = true;
											}

											if (StdDraw.isMousePressed()){
												//Button 03 Command
												System.out.println("Button 03 is CLICKED");
												isFromBackToMenu = true;
												isFromGameWindows = true;
												if (!isSaved){
													exitSaveReminder.generateExitSaveReminderWindows();
													if (StdDraw.isMousePressed()){
														try {
															mouseReset();
														} catch (AWTException e) {
															e.printStackTrace();
														}
													}
													exitSaveReminder.drawExitSaveReminder();
													windowsStatus = 5;
													isGaming = false;
												}else {
													startWindows.generateStartWindows();
													if (StdDraw.isMousePressed()){
														try {
															mouseReset();
														} catch (AWTException e) {
															e.printStackTrace();
														}
													}
													startWindows.drawStart();
													windowsStatus = 0;
													isCleared = false;
												}

											}
										}else {
											//按钮04
											if (844<mouseX &&mouseX<1004  &&  150<mouseY && mouseY<210 && board.canUndo()){
												if(!isDrawn) {
													gameWindows.drawMenuPress(4);
													isDrawn = true;
												}

												if (StdDraw.isMousePressed()){
													//Button 04 Command
													System.out.println("Button 04 is CLICKED");
													try {
														board.undo();
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													gameWindows.drawChessReverse(board.getUndoX(),board.getUndoY());
													timer2.restore();
													isSaved = false;
													if(!isWin) {
														try {
															Thread.sleep(200);
														} catch (InterruptedException e) {
															e.printStackTrace();
														}
														gameWindows.drawPlayer(board.getMoveTimes() % 2 == 0);
														System.out.println("moveTimes: " + board.getMoveTimes());
														gameWindows.drawPlayer(board.getMoveTimes() % 2 == 0);
														isPlayerDrawn = true;
													}
													if (StdDraw.isMousePressed()){
														try {
															mouseReset();
														} catch (AWTException e) {
															e.printStackTrace();
														}
													}
												}
											}else {
												//按钮05
												if (1042<mouseX &&mouseX<1204  &&  150<mouseY && mouseY<210){
													if(!isDrawn) {
														gameWindows.drawMenuPress(5);
														isDrawn = true;
													}

													if (StdDraw.isMousePressed()){
														//Button 05 Command
														System.out.println("Button 05 is CLICKED");
														if (!isSaved){
															isFromExit = true;
															isFromGameWindows = true;
															exitSaveReminder.generateExitSaveReminderWindows();
															if (StdDraw.isMousePressed()){
																try {
																	mouseReset();
																} catch (AWTException e) {
																	e.printStackTrace();
																}
															}
															exitSaveReminder.drawExitSaveReminder();
															windowsStatus = 5;
															isGaming = false;
														}else {
															System.exit(0);
														}
														if (StdDraw.isMousePressed()){
															try {
																mouseReset();
															} catch (AWTException e) {
																e.printStackTrace();
															}
														}
													}
												}else {
													if(isDrawn) {
														gameWindows.drawMenu(1);
														gameWindows.drawMenu(2);
														gameWindows.drawMenu(3);
														gameWindows.drawMenu(4);
														gameWindows.drawMenu(5);
														isDrawn = false;
													}

												}
											}
										}
									}
								}
							}
							if (!GUI.isChessDrawn) {
								gameWindows.drawAllChess(board);
								gameWindows.drawAllChess(board);
								gameWindows.drawAllChess(board);
								GUI.isChessDrawn = true;
							}
							break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// GameWindowsPause
						case 2:
							if(!timer1.isPaused() || !timer2.isPaused()) {
								timer1.pause();
								timer2.pause();
								thread1[0].interrupt();
								thread2[0].interrupt();
							}
							//按钮01
							if (844<mouseX &&mouseX<1204  &&  473<mouseY && mouseY<537){
								if(!isDrawn) {
									gameWindows.drawMenuPausePress(1);
									isDrawn = true;
								}


								if (StdDraw.isMousePressed()){
									//Button 01 Command
									gameWindows.drawMenu();
									if (StdDraw.isMousePressed()){
										try {
											mouseReset();
										} catch (AWTException e) {
											e.printStackTrace();
										}
									}
									windowsStatus = 1;
									isGaming = true;
								}
							}
							else {
								//按钮02
								if (844<mouseX &&mouseX<1204  &&  362<mouseY && mouseY<426 && !isMachine){
									if(!isDrawn) {
										gameWindows.drawMenuPausePress(2);
										isDrawn = true;
									}

									if (StdDraw.isMousePressed()){
										//Button 02 Command
										System.out.println("Button 02 is CLICKED");
										try {
											board.setTimeSpent(timer1.getTimeSpent());
											board.setTimeLeft(timer2.getTimeLeft());
											board.save();

											isSaved = true;
										} catch (FileNotFoundException e) {
											e.printStackTrace();
										}
										if (StdDraw.isMousePressed()){
											try {
												mouseReset();
											} catch (AWTException e) {
												e.printStackTrace();
											}
										}
									}
								}else {
									//按钮03
									if (844<mouseX &&mouseX<1204  &&  259<mouseY && mouseY<318){
										if(!isDrawn) {
											gameWindows.drawMenuPausePress(3);
											isDrawn = true;
										}

										if (StdDraw.isMousePressed()){
											//Button 03 Command
											System.out.println("Button 03 is CLICKED");
											isFromBackToMenu = true;
											isFromGamePauseWindows = true;
											if (!isSaved){
												exitSaveReminder.generateExitSaveReminderWindows();
												exitSaveReminder.drawExitSaveReminder();
												windowsStatus = 5;
												isGaming = false;
												if (StdDraw.isMousePressed()){
													try {
														mouseReset();
													} catch (AWTException e) {
														e.printStackTrace();
													}
												}
											}
											else {
												startWindows.generateStartWindows();
												startWindows.drawStart();
												windowsStatus = 0;
												isGaming = false;
												if (StdDraw.isMousePressed()){
													try {
														mouseReset();
													} catch (AWTException e) {
														e.printStackTrace();
													}
												}
											}
											if (StdDraw.isMousePressed()){
												try {
													mouseReset();
												} catch (AWTException e) {
													e.printStackTrace();
												}
											}
										}
									}
									else {
										//按钮04
										if (844<mouseX &&mouseX<1004  &&  150<mouseY && mouseY<210){
											//gameWindows.drawMenuPausePress(4);
											//if (StdDraw.isMousePressed()){
											//	//Button 04 Command
											//	System.out.println("Button 04 is CLICKED");
											//	if (StdDraw.isMousePressed()){
											//		try {
											//			mouseReset();
											//		} catch (AWTException e) {
											//			e.printStackTrace();
											//		}
											//	}
											//}
										}
										else {
											//按钮05
											if (1042<mouseX &&mouseX<1204  &&  150<mouseY && mouseY<210){
												if(!isDrawn) {
													gameWindows.drawMenuPausePress(5);
													isDrawn = true;
												}

												if (StdDraw.isMousePressed()){
													//Button 05 Command
													System.out.println("Button 05 is CLICKED");
													if (!isSaved){
														isFromExit = true;
														isFromGamePauseWindows = true;
														exitSaveReminder.generateExitSaveReminderWindows();
														if (StdDraw.isMousePressed()){
															try {
																mouseReset();
															} catch (AWTException e) {
																e.printStackTrace();
															}
														}
														exitSaveReminder.drawExitSaveReminder();
														windowsStatus = 5;
														isGaming = false;
													}else {
														System.exit(0);
													}
													if (StdDraw.isMousePressed()){
														try {
															mouseReset();
														} catch (AWTException e) {
															e.printStackTrace();
														}
													}
												}
											}
											else {
												if(isDrawn) {
													gameWindows.drawMenuPause(1);
													gameWindows.drawMenuPause(2);
													gameWindows.drawMenuPause(3);
													gameWindows.drawMenuPause(4);
													gameWindows.drawMenuPause(5);
													isDrawn = false;
												}

											}
										}
									}
								}
							}
							if (windowsStatus == 2 && !GUI.isChessDrawn)  {
								try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								gameWindows.drawAllChess(board);
								gameWindows.drawAllChess(board);
								gameWindows.drawAllChess(board);
								if(!isWin) {
									try {
										Thread.sleep(200);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									gameWindows.drawPlayer(board.getMoveTimes() % 2 == 0);
									gameWindows.drawPlayer(board.getMoveTimes() % 2 == 0);
								}
								isPlayerDrawn = true;
								GUI.isChessDrawn = true;
							}
							break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// SettingWindows
						case 3:
							if (93<mouseX && mouseX<456  &&  473<mouseY && mouseY<537){
								if(!isDrawn) {
									settingWindows.drawOptionsPress(1);
									isDrawn = true;
								}
								if (StdDraw.isMousePressed()){
									//Button 01 Command
									System.out.println("Button 01 is CLICKED");
									board.setBoardSize(15);
									gameWindows.setBoardSize(15);
									broadSize = 15;
									stepLength = 504.0/(broadSize-1);
									settingWindows.drawOptions(2);
									settingWindows.drawOptions(3);
									if (StdDraw.isMousePressed()){
										try {
											mouseReset();
										} catch (AWTException e) {
											e.printStackTrace();
										}
									}
								}
							}
							else {
								//Button 02
								if (93<mouseX && mouseX<456  &&  362<mouseY && mouseY<426){
									if(!isDrawn) {
										settingWindows.drawOptionsPress(2);
										isDrawn = true;
									}

									if (StdDraw.isMousePressed()){
										//Button 02 Command
										System.out.println("Button 02 is CLICKED");
										board.setBoardSize(17);
										gameWindows.setBoardSize(17);
										broadSize = 17;
										stepLength = 504.0/(broadSize-1);
										settingWindows.drawOptions(1);
										settingWindows.drawOptions(3);
										if (StdDraw.isMousePressed()){
											try {
												mouseReset();
											} catch (AWTException e) {
												e.printStackTrace();
											}
										}
									}
								}else {
									//Button 03
									if (93<mouseX && mouseX<456  &&  259<mouseY && mouseY<318){
										if(!isDrawn) {
											settingWindows.drawOptionsPress(3);
											isDrawn = true;
										}
										if (StdDraw.isMousePressed()){
											//Button 03 Command
											System.out.println("Button 03 is CLICKED");
											board.setBoardSize(19);
											gameWindows.setBoardSize(19);
											broadSize = 19;
											stepLength = 504.0/(broadSize-1);
											settingWindows.drawOptions(1);
											settingWindows.drawOptions(2);
											if (StdDraw.isMousePressed()){
												try {
													mouseReset();
												} catch (AWTException e) {
													e.printStackTrace();
												}
											}
										}
									}else {
										//Button 04
										if (93<mouseX && mouseX<253  &&  150<mouseY && mouseY<210){
											if(!isDrawn) {
												settingWindows.drawOptionsPress(4);
												isDrawn = true;
											}

											if (StdDraw.isMousePressed()){
												//Button 04 Command
												System.out.println("Button 04 is CLICKED");
												if (enableForbidden){
													enableForbidden = false;
												}else {
													enableForbidden = true;
												}
												if (StdDraw.isMousePressed()){
													try {
														mouseReset();
													} catch (AWTException e) {
														e.printStackTrace();
													}
												}
											}
										}else {
											//Button 05
											if (290<mouseX && mouseX<456  &&  150<mouseY && mouseY<210){
												if(!isDrawn) {
													settingWindows.drawOptionsPress(5);
													isDrawn = true;
												}
												if (StdDraw.isMousePressed()){
													//Button 05 Command
													System.out.println("Button 05 is CLICKED");
													startWindows.drawStart();
													windowsStatus = 0;
													isGaming = false;
													if (StdDraw.isMousePressed()){
														try {
															mouseReset();
														} catch (AWTException e) {
															e.printStackTrace();
														}
													}
												}
											}else {
												if(isDrawn) {
													settingWindows.drawOptions(1);
													settingWindows.drawOptions(2);
													settingWindows.drawOptions(3);
													settingWindows.drawOptions(4);
													settingWindows.drawOptions(5);
													isDrawn = false;
												}
											}
										}
									}
								}
							}
							if (broadSize == 15) settingWindows.drawOptionsChosen(1);
							if (broadSize == 17) settingWindows.drawOptionsChosen(2);
							if (broadSize == 19) settingWindows.drawOptionsChosen(3);
							if (enableForbidden) settingWindows.drawOptionsChosen(4);
							break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// NoSavesWindows
						case 4:
							if(!timer1.isPaused() || !timer2.isPaused()) {
								timer1.reset();
								timer2.reset();
								thread1[0].interrupt();
								thread2[0].interrupt();
							}
							if (49<mouseX && mouseX<412  &&  69<mouseY && mouseY<130){
								noSavesWindows.drawNoSavesPress();
								if (StdDraw.isMousePressed()){
									//Button 01 Command
									startWindows.generateStartWindows();
									if (StdDraw.isMousePressed()){
										try {
											mouseReset();
										} catch (AWTException e) {
											e.printStackTrace();
										}
									}
									if (StdDraw.isMousePressed()){
										try {
											mouseReset();
										} catch (AWTException e) {
											e.printStackTrace();
										}
									}
									startWindows.drawStart();
									windowsStatus = 0;
									isGaming = false;
								}
							}
							else {
								noSavesWindows.drawNoSaves();
							}
							break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ExitSaveReminderFromGameWindows
						case 5:
							if(!timer1.isPaused() || !timer2.isPaused()) {
								timer1.pause();
								timer2.pause();
								thread1[0].interrupt();
								thread2[0].interrupt();
							}
							//Button 01
							if (34<mouseX && mouseX<146  &&  61<mouseY && mouseY<104){
								exitSaveReminder.drawExitSaveReminderPress(1);
								exitSaveReminder.drawExitSaveReminder(2);
								exitSaveReminder.drawExitSaveReminder(3);
								if (StdDraw.isMousePressed()){
									//Button 01 Command
									System.out.println("Button 01 is CLICKED");
									try {
										board.setTimeSpent(timer1.getTimeSpent());
										board.setTimeLeft(timer2.getTimeLeft());
										board.save();
										if (isFromBackToMenu){
											startWindows.generateStartWindows();
											isFromBackToMenu = false;
											startWindows.drawStart();
											windowsStatus = 0;
											isGaming = false;
											if (StdDraw.isMousePressed()){
												try {
													mouseReset();
												} catch (AWTException e) {
													e.printStackTrace();
												}
											}
										}else {
											if (isFromExit){
												System.exit(0);
											}
										}
									} catch (FileNotFoundException e) {
										e.printStackTrace();
									}
								}
							}
							else {
								exitSaveReminder.drawExitSaveReminder(1);
								//Button 02
								if (169<mouseX && mouseX<285  &&  61<mouseY && mouseY<104){
									exitSaveReminder.drawExitSaveReminderPress(2);
									exitSaveReminder.drawExitSaveReminder(1);
									exitSaveReminder.drawExitSaveReminder(3);
									if (StdDraw.isMousePressed()){
										//Button 02 Command
										if (isFromBackToMenu){
											startWindows.generateStartWindows();
											isFromBackToMenu = false;
											startWindows.drawStart();
											windowsStatus = 0;
											isGaming = false;
											if (StdDraw.isMousePressed()){
												try {
													mouseReset();
												} catch (AWTException e) {
													e.printStackTrace();
												}
											}
										}else {
											if (isFromExit){
												System.exit(0);
											}
										}
										System.out.println("Button 02 is CLICKED");
										if (StdDraw.isMousePressed()){
											try {
												mouseReset();
											} catch (AWTException e) {
												e.printStackTrace();
											}
										}
									}
								}else {
									exitSaveReminder.drawExitSaveReminder(2);
									//Button 03
									if (308<mouseX && mouseX<420  &&  61<mouseY && mouseY<104){
										exitSaveReminder.drawExitSaveReminderPress(3);
										exitSaveReminder.drawExitSaveReminder(1);
										exitSaveReminder.drawExitSaveReminder(2);
										if (StdDraw.isMousePressed()){
											//Button 03 Command
											System.out.println("Button 03 is CLICKED");
											if (isFromGameWindows){
												gameWindows.generateGameWindows();
												isFromGameWindows = false;
												if (StdDraw.isMousePressed()){
													try {
														mouseReset();
													} catch (AWTException e) {
														e.printStackTrace();
													}
												}
												gameWindows.drawCanvas();
												gameWindows.drawMenu();
												gameWindows.drawAllChess(board);
												windowsStatus = 2;
												isGaming = true;
											}else {
												if (isFromGamePauseWindows){
													gameWindows.generateGameWindows();
													isFromGamePauseWindows = false;
													if (StdDraw.isMousePressed()){
														try {
															mouseReset();
														} catch (AWTException e) {
															e.printStackTrace();
														}
													}
													gameWindows.drawCanvas();
													gameWindows.drawMenuPause();
													gameWindows.drawAllChess(board);
													windowsStatus = 2;
													isGaming = false;
												}
											}
										}
									}else {
										exitSaveReminder.drawExitSaveReminder(3);
									}
								}
							}
							break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// winnerWindows
						case 6:
							if(thread1[0].getState() != Thread.State.TERMINATED && thread2[0].getState() != Thread.State.TERMINATED) {
								thread1[0].interrupt();
								thread2[0].interrupt();
								System.out.println("test");
							}
							gameWindows.drawAllChess(board);
							if(!isTimerDrawn) {
								isTimerDrawn = true;
								try {
									timer1.drawTimer(30, 1280, 720);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								try {
									timer2.drawTimerLeft(30, 1280, 720);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								try {
									timer1.drawTimer(30, 1280, 720);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								try {
									timer2.drawTimerLeft(30, 1280, 720);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							//按钮01
							if (844<mouseX &&mouseX<1204  &&  473<mouseY && mouseY<537){
								if(!isDrawn) {
									winnerWindows.drawMenuWinPress(1);
									isDrawn = true;
								}

								if (StdDraw.isMousePressed()){
									//Button 01 Command
									gameWindows.drawCanvas();
									gameWindows.drawMenu();
									if (StdDraw.isMousePressed()){
										try {
											mouseReset();
										} catch (AWTException e) {
											e.printStackTrace();
										}
									}
									board.initializeBoard();
									timer1.reset();
									timer2.reset();
									windowsStatus = 1;
									isTimerDrawn = false;
									isGaming = true;
									isWin = false;
									isPlayerDrawn = false;
									color = 1;
								}
							}
							else {
								//按钮02
								if (844<mouseX &&mouseX<1204  &&  362<mouseY && mouseY<426){
									//按纽02禁用
								}else {
									//按钮03
									if (844<mouseX &&mouseX<1204  &&  259<mouseY && mouseY<318){
										if(!isDrawn) {
											winnerWindows.drawMenuWinPress(3);
											isDrawn = true;
										}
										if (StdDraw.isMousePressed()){
											//Button 03 Command
											startWindows.generateStartWindows();
											startWindows.drawStart();
											if (StdDraw.isMousePressed()){
												try {
													mouseReset();
												} catch (AWTException e) {
													e.printStackTrace();
												}
											}
											windowsStatus = 0;
											isTimerDrawn = false;
											isGaming = false;
											isWin = false;
											TimerPlus.setEnd(false);
										}
									}else {
										//按钮04
										if (844<mouseX &&mouseX<1004  &&  150<mouseY && mouseY<210 && board.canUndo()){
											//winnerWindows.drawMenuWinPress(4);
											//winnerWindows.drawMenuWinUnPress(1);
											//winnerWindows.drawMenuWinUnPress(3);
											//winnerWindows.drawMenuWinUnPress(5);
											//if (StdDraw.isMousePressed()){
											//	//Button 04 Command
											//	gameWindows.drawMenu();
											//	board.undo();
											//	gameWindows.drawChessReverse(board.getUndoX(),board.getUndoY());
											//	if (StdDraw.isMousePressed()){
											//		try {
											//			mouseReset();
											//		} catch (AWTException e) {
											//			e.printStackTrace();
											//		}
											//	}
											//	windowsStatus = 1;
											//	isGaming = true;
											//}
										}else {
											//按钮05
											if (1042<mouseX &&mouseX<1204  &&  150<mouseY && mouseY<210){
												if(!isDrawn) {
													winnerWindows.drawMenuWinPress(5);
													isDrawn = true;
												}
												if(StdDraw.isMousePressed()) {
													System.exit(0);
												}
											}else {
												winnerWindows.drawMenuWinUnPress(1);
												winnerWindows.drawMenuWinUnPress(2);
												winnerWindows.drawMenuWinUnPress(3);
												winnerWindows.drawMenuWinUnPress(4);
												winnerWindows.drawMenuWinUnPress(5);
												try {
													winnerWindows.drawMenuWinTitle(winnerColor);
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												isDrawn = false;
											}
										}
									}
								}
							}
							break;
					}
				}
				//switch的大括号
				// System.out.println(windowsStatus);
				StdDraw.show();
			}
		},0,33);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//鼠标监听线程段结束
		while (true){
			if (StdDraw.isMousePressed() && windowsStatus==1 && isGaming && mouseX<700){
				System.out.println("Clicking");
				//落子模块
				if (board.isBlocked(x,y)){
					System.out.println("is blocked");
				}else {
					if (board.isForbidden(x,y) && enableForbidden && color == 1){
						StdDraw.setPenColor(235,245,255);
						StdDraw.filledRectangle(1024, 612, 200, 50);
						GUI.drawTitle(1024, 612, 30, "Forbidden Move!");
						isTitleDrawn = false;
						continue;
					}else {
						thread2[0].interrupt();
						timer2.restore();
						timer2.restore();
						board.playChess(x,y);
						board.stepRecord(x,y);
						GUI.isChessDrawn = false;
						isPlayerDrawn = false;
						isSaved = false;
					}
				}
				//输赢判断
				if (board.isWin(x,y)){
					isWin = true;
					System.out.println("Game Over!");
					TimerPlus.setEnd(true);
					Thread.sleep(200);
					gameWindows.drawAllChess(board);
					if (color == 1) {
						winnerColor = 2;
					}else {
						if (color == 2){
							winnerColor = 1;
						}else {
							winnerColor = 0;
						}
					}
					isGaming = false;
					winnerWindows.drawMenuWin(winnerColor);
					winnerWindows.drawMenuWinTitle(winnerColor);
					winnerWindows.drawMenuWin(winnerColor);
					winnerWindows.drawMenuWinTitle(winnerColor);
					winnerWindows.drawMenuWin(winnerColor);
					winnerWindows.drawMenuWinTitle(winnerColor);
					windowsStatus = 6;
				}

				if (StdDraw.isMousePressed()){
					try {
						mouseReset();
					} catch (AWTException e) {
						e.printStackTrace();
					}
				}
			}
			else if(isMachine && (board.getMoveTimes() % 2 == 1) && !isWin) {
				System.out.println("AI working");
				AI ai = new AI(board);
				AI.size = board.getBoardSize();
				int size = board.getBoardSize();
				int[]temp1=new int[5];
				int[]temp2=new int[6];
				int[]temp3=new int[7];
				double[][][][][]hs=new double[10][size][size][size][4];
				double[][][][][]ss=new double[8][size][size][size][4];
				double[][][][][]ha=new double[6][size][size][size][4];
				double[][][][][]sa=new double[4][size][size][size][4];
				int chess=1;
				System.out.println(board.chessBoard.length);
				AI.compare(temp1,temp2,temp3, board.chessBoard ,hs,ss,ha,sa);
				AI.action( chess,size,board.chessBoard ,hs,ss,ha,sa);
				x = ai.getX();
				y = ai.getY();
				System.out.println(x + " " + y);
				//落子模块
				if (board.isBlocked(x,y)){
					System.out.println("is blocked");
				}else {
					if (board.isForbidden(x,y) && enableForbidden && color == 1) {
						StdDraw.setPenColor(235,245,255);
						StdDraw.filledRectangle(1024, 612, 200, 50);
						GUI.drawTitle(1024, 612, 30, "Forbidden Move!");
						isTitleDrawn = false;
						continue;
					} else {
						thread2[0].interrupt();
						timer2.restore();
						timer2.restore();
						board.playChess(x,y);
						board.stepRecord(x,y);
						GUI.isChessDrawn = false;
						isPlayerDrawn = false;
						isSaved = false;
					}
				}
				//输赢判断
				if (board.isWin(x,y)){
					isWin = true;
					System.out.println("Game Over!");
					TimerPlus.setEnd(true);
					Thread.sleep(200);
					gameWindows.drawAllChess(board);
					if (color == 1) {
						winnerColor = 2;
					}else {
						if (color == 2){
							winnerColor = 1;
						}else {
							winnerColor = 0;
						}
					}
					isGaming = false;
					winnerWindows.drawMenuWin(winnerColor);
					winnerWindows.drawMenuWinTitle(winnerColor);
					winnerWindows.drawMenuWin(winnerColor);
					winnerWindows.drawMenuWinTitle(winnerColor);
					winnerWindows.drawMenuWin(winnerColor);
					winnerWindows.drawMenuWinTitle(winnerColor);
					windowsStatus = 6;
				}
			}
		}
	}








	// add other methods here
	public static void mouseReset() throws AWTException {
		Robot robot = new Robot();
		robot.mousePress(InputEvent.BUTTON1_MASK);
		for (int t=0 ; t<1200 ; t++){
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		}
	}

	public static int toChessGridX(double mouesX){
		int result = 0;
		double originX = (mouesX - 108)/stepLength;
		double min = Math.floor(originX);
		double max = Math.ceil(originX);
		double half = min+0.5;
		//System.out.println(min+"   "+ originX +"   "+max);
		if (originX <= 0) return 0;
		if (originX >= broadSize-1) return broadSize-1;

		if (originX >= half) result = (int)max;
		if (originX < half) result = (int)min;
		return result;
	}

	public static int toChessGridY(double mouesY){
		int result = 0;
		double originY = (mouesY - 108)/stepLength;
		double min = Math.floor(originY);
		double max = Math.ceil(originY);
		double half = min+0.5;
		//System.out.println(min+"   "+ originY +"   "+max);
		if (originY <= 0) return broadSize-1;
		if (originY >= broadSize-1) return 0;

		if (originY >= half) result = (int)max;
		if (originY < half) result = (int)min;
		return broadSize-1-result;
	}

}
