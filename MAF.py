#!/usr/bin/env python
# coding: utf-8

import cv2
import time 
import pyautogui


def main():
	for i in range(1,11):
		print(i)
		time.sleep(1)
		
	#鱼钩所在的范围
	(x,y) = pyautogui.size()
	leftBoundary = x * 0.49
	topBoundary = y * 0.55
	width = x * 0.02
	height = y * 0.15
	#开始钓鱼
	pyautogui.click(button="right")
	print("Start fishing")
	#等待落钩
	time.sleep(1)
	#鱼钩是否在所选的范围内
	pyautogui.screenshot("initialImg.png",region =  (leftBoundary,topBoundary,width,height))

	while 1:
		pyautogui.screenshot("check.png",region = (leftBoundary,topBoundary,width,height))

		img = cv2.imread("check.png")
		gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
		blur = cv2.GaussianBlur(gray,(5,5),0)
		ret,binary = cv2.threshold(blur,125,255,cv2.THRESH_BINARY)
		conts,hiera = cv2.findContours(binary,cv2.RETR_TREE,cv2.CHAIN_APPROX_SIMPLE)

		if (len(conts)==0):
			print("钓到鱼了")
			#收勾
			pyautogui.click(button="right")
			#甩勾
			pyautogui.click(button ="right")
			time.sleep(1)
		time.sleep(0.3)



if __name__ == '__main__':
	main()