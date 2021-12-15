import java.awt.*;
import java.awt.event.InputEvent;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.TimerTask;
import java.util.Timer;

public class Gomoku {
	private static int windowsStatus = 0;
	// startWindows = 0 ; gameWindows = 1 ; gamePauseWindows = 2 ; settingWindows = 3 ; noSavesWindows = 4 ; exitSaveReminder = 5;
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
	public static boolean enableForbidden = true;
	public static boolean isSaved = false;
	public static boolean isFromGameWindows = false;
	public static boolean isFromGamePauseWindows = false;
	public static boolean isFromBackToMenu = false;
	public static boolean isFromExit = false;

	public static void main(String[] args) throws AWTException {
		GUI startWindows = new GUI(540, 720);
		GUI gameWindows = new GUI(1280, 720);
		GUI settingWindows = new GUI(540,720);
		GUI noSavesWindows = new GUI(450,250);
		GUI exitSaveReminder = new GUI(450,250);

		ChessBoard board = new ChessBoard(15);

		StdDraw.enableDoubleBuffering();

		startWindows.generateStartWindows();
		startWindows.drawStart();
		StdDraw.show();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//鼠标监听线程段开始
		Timer mouse = new Timer();
		mouse.schedule(new TimerTask() {
			@Override
			public void run() {
				mouseX = StdDraw.mouseX();
				mouseY = StdDraw.mouseY();
				//System.out.println(mouseX+" "+mouseY+"    ");

				switch (windowsStatus){// startWindows = 0 ; gameWindows = 1 ; gamePauseWindows = 2 ; settingWindows = 3 ; noSavesWindows = 4 ; exitSaveReminder = 5;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// StartWindows
					case 0:
						//Button 01
						if (93<mouseX &&mouseX<456  &&  473<mouseY && mouseY<537){
							startWindows.drawStartPress(1);
							if (StdDraw.isMousePressed()){
								//Button 01 Command
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
								isSaved = true;
							}
						}else {
							startWindows.drawStart(1);
							//Button 02
							if (93<mouseX &&mouseX<456  &&  362<mouseY && mouseY<426){
								startWindows.drawStartPress(2);
								if (StdDraw.isMousePressed()){
									try {
										board.load();
										gameWindows.generateGameWindows();
										isSaved = true;
										if (StdDraw.isMousePressed()){
											try {
												mouseReset();
											} catch (AWTException e) {
												e.printStackTrace();
											}
										}
										gameWindows.drawCanvas();
										gameWindows.drawMenuPause();
										windowsStatus = 2;
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
								startWindows.drawStart(2);
								//Button 03
								if (93<mouseX &&mouseX<456  &&  259<mouseY && mouseY<318){
									startWindows.drawStartPress(3);
									if (StdDraw.isMousePressed()){
										//Button 03 Command
										System.out.println("Button 03 is CLICKED");
										if (StdDraw.isMousePressed()){
											try {
												mouseReset();
											} catch (AWTException e) {
												e.printStackTrace();
											}
										}
									}
								}else {
									startWindows.drawStart(3);
									//Button 04
									if (93<mouseX &&mouseX<253  &&  150<mouseY && mouseY<210){
										startWindows.drawStartPress(4);
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
										}
									}else {
										startWindows.drawStart(4);
										//Button 05
										if (290<mouseX &&mouseX<456  &&  150<mouseY && mouseY<210){
											startWindows.drawStartPress(5);
											if (StdDraw.isMousePressed()){
												//Button 05 Command
												System.exit(0);
											}
										}else {
											startWindows.drawStart(5);
										}
									}
								}
							}
						}
						break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// GameWindows
					case 1:
						//拟落子位置显示及落子步骤
						if (mouseX<700){
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
							}
						}else {
							gameWindows.drawChessReverse(lastX,lastY);
							//按钮01
							if (844<mouseX &&mouseX<1204  &&  473<mouseY && mouseY<537){
								gameWindows.drawMenuPress(1);
								if (StdDraw.isMousePressed()){
									//Button 01 Command
									gameWindows.drawMenuPause();
									windowsStatus = 2;
									if (StdDraw.isMousePressed()){
										try {
											mouseReset();
										} catch (AWTException e) {
											e.printStackTrace();
										}
									}
								}
							}else {
								gameWindows.drawMenu(1);
								//按钮02
								if (844<mouseX &&mouseX<1204  &&  362<mouseY && mouseY<426){
									gameWindows.drawMenuPress(2);
									if (StdDraw.isMousePressed()){
										//Button 02 Command
										System.out.println("Button 02 is CLICKED");
										try {
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
									gameWindows.drawMenu(2);
									//按钮03
									if (844<mouseX &&mouseX<1204  &&  259<mouseY && mouseY<318){
										gameWindows.drawMenuPress(3);
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
											}

										}
									}else {
										gameWindows.drawMenu(3);
										//按钮04
										if (844<mouseX &&mouseX<1004  &&  150<mouseY && mouseY<210 && board.canUndo()){
											gameWindows.drawMenuPress(4);
											if (StdDraw.isMousePressed()){
												//Button 04 Command
												System.out.println("Button 04 is CLICKED");
												try {
													board.undo();
													gameWindows.drawChessReverse(board.getUndoX(),board.getUndoY());
													isSaved = false;
												}catch (EmptyStackException e){
													System.out.println("Can not undo");
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
											gameWindows.drawMenu(4);
											//按钮05
											if (1042<mouseX &&mouseX<1204  &&  150<mouseY && mouseY<210){
												gameWindows.drawMenuPress(5);
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
												gameWindows.drawMenu(5);
												//界面还原
											}
										}
									}
								}
							}
						}
						if (windowsStatus == 1) gameWindows.drawAllChess(board);
						break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// GameWindowsPause
					case 2:
						//按钮01
						if (844<mouseX &&mouseX<1204  &&  473<mouseY && mouseY<537){
							gameWindows.drawMenuPausePress(1);
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
							}
						}else {
							gameWindows.drawMenuPause(1);
							//按钮02
							if (844<mouseX &&mouseX<1204  &&  362<mouseY && mouseY<426){
								gameWindows.drawMenuPausePress(2);
								if (StdDraw.isMousePressed()){
									//Button 02 Command
									System.out.println("Button 02 is CLICKED");
									try {
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
								gameWindows.drawMenuPause(2);
								//按钮03
								if (844<mouseX &&mouseX<1204  &&  259<mouseY && mouseY<318){
									gameWindows.drawMenuPausePress(3);
									if (StdDraw.isMousePressed()){
										//Button 03 Command
										System.out.println("Button 03 is CLICKED");
										isFromBackToMenu = true;
										isFromGamePauseWindows = true;
										if (!isSaved){
											exitSaveReminder.generateExitSaveReminderWindows();
											exitSaveReminder.drawExitSaveReminder();
											windowsStatus = 5;
											if (StdDraw.isMousePressed()){
												try {
													mouseReset();
												} catch (AWTException e) {
													e.printStackTrace();
												}
											}
										}else {
											startWindows.generateStartWindows();
											startWindows.drawStart();
											windowsStatus = 0;
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
								}else {
									gameWindows.drawMenuPause(3);
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
									}else {
										gameWindows.drawMenuPause(4);
										//按钮05
										if (1042<mouseX &&mouseX<1204  &&  150<mouseY && mouseY<210){
											gameWindows.drawMenuPausePress(5);
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
											gameWindows.drawMenuPause(5);
										}
									}
								}
							}
						}
						if (windowsStatus == 2) gameWindows.drawAllChess(board);
						break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// SettingWindows
					case 3:
						if (93<mouseX && mouseX<456  &&  473<mouseY && mouseY<537){
							settingWindows.drawOptionsPress(1);
							if (StdDraw.isMousePressed()){
								//Button 01 Command
								System.out.println("Button 01 is CLICKED");
								board.setBoardSize(15);
								gameWindows.setBoardSize(15);
								broadSize = 15;
								stepLength = 504.0/(broadSize-1);
								if (StdDraw.isMousePressed()){
									try {
										mouseReset();
									} catch (AWTException e) {
										e.printStackTrace();
									}
								}
							}
						}else {
							settingWindows.drawOptions(1);
							//Button 02
							if (93<mouseX && mouseX<456  &&  362<mouseY && mouseY<426){
								settingWindows.drawOptionsPress(2);
								if (StdDraw.isMousePressed()){
									//Button 02 Command
									System.out.println("Button 02 is CLICKED");
									board.setBoardSize(17);
									gameWindows.setBoardSize(17);
									broadSize = 17;
									stepLength = 504.0/(broadSize-1);
									if (StdDraw.isMousePressed()){
										try {
											mouseReset();
										} catch (AWTException e) {
											e.printStackTrace();
										}
									}
								}
							}else {
								settingWindows.drawOptions(2);
								//Button 03
								if (93<mouseX && mouseX<456  &&  259<mouseY && mouseY<318){
									settingWindows.drawOptionsPress(3);
									if (StdDraw.isMousePressed()){
										//Button 03 Command
										System.out.println("Button 03 is CLICKED");
										board.setBoardSize(19);
										gameWindows.setBoardSize(19);
										broadSize = 19;
										stepLength = 504.0/(broadSize-1);
										if (StdDraw.isMousePressed()){
											try {
												mouseReset();
											} catch (AWTException e) {
												e.printStackTrace();
											}
										}
									}
								}else {
									settingWindows.drawOptions(3);
									//Button 04
									if (93<mouseX && mouseX<253  &&  150<mouseY && mouseY<210){
										settingWindows.drawOptionsPress(4);
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
										settingWindows.drawOptions(4);
										//Button 05
										if (290<mouseX && mouseX<456  &&  150<mouseY && mouseY<210){
											settingWindows.drawOptionsPress(5);
											if (StdDraw.isMousePressed()){
												//Button 05 Command
												System.out.println("Button 05 is CLICKED");
												startWindows.drawStart();
												windowsStatus = 0;
												if (StdDraw.isMousePressed()){
													try {
														mouseReset();
													} catch (AWTException e) {
														e.printStackTrace();
													}
												}
											}
										}else {
											settingWindows.drawOptions(5);
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
							}
						}else {
							noSavesWindows.drawNoSaves();
						}
						break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ExitSaveReminderFromGameWindows
					case 5:
						if (34<mouseX && mouseX<146  &&  61<mouseY && mouseY<104){
							exitSaveReminder.drawExitSaveReminderPress(1);
							if (StdDraw.isMousePressed()){
								//Button 01 Command
								System.out.println("Button 01 is CLICKED");
								try {
									board.save();
									if (isFromBackToMenu){
										startWindows.generateStartWindows();
										isFromBackToMenu = false;
										startWindows.drawStart();
										windowsStatus = 0;
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
						}else {
							exitSaveReminder.drawExitSaveReminder(1);
							if (169<mouseX && mouseX<285  &&  61<mouseY && mouseY<104){
								exitSaveReminder.drawExitSaveReminderPress(2);
								if (StdDraw.isMousePressed()){
									//Button 02 Command
									if (isFromBackToMenu){
										startWindows.generateStartWindows();
										isFromBackToMenu = false;
										startWindows.drawStart();
										windowsStatus = 0;
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
								if (308<mouseX && mouseX<420  &&  61<mouseY && mouseY<104){
									exitSaveReminder.drawExitSaveReminderPress(3);
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
											windowsStatus = 1;
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
											}
										}
									}
								}else {
									exitSaveReminder.drawExitSaveReminder(3);
								}
							}
						}
						break;

				}//switch的大括号
				System.out.println(windowsStatus);
				StdDraw.show();
			}
		},0,1);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//鼠标监听线程段结束
		while (true){
			if (StdDraw.isMousePressed() && windowsStatus==1 && mouseX<700){
				System.out.println("Clicking");
				//落子模块
				if (board.isBlocked(x,y)){
					System.out.println("is blocked");
				}else {
					if (board.isForbidden(x,y) && enableForbidden){
						System.out.println("is Forbidden");
					}else {
						board.playChess(x,y);
						board.stepRecord(x,y);
						isSaved = false;
					}
				}
				//输赢判断
				if (board.isWin(x,y)){
					//mouse.cancel();
					StdDraw.clear();
					gameWindows.drawCanvas();
					gameWindows.drawCanvas();
					gameWindows.drawCanvas();
					gameWindows.drawMenu();
					gameWindows.drawAllChess(board);
					gameWindows.drawAllChess(board);
					gameWindows.drawAllChess(board);
					StdDraw.show();
					System.out.println("Game over");
					break;
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
