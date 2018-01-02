$count = 0

While $count <> 10
   $firefox = WinActivate("File Upload")
   $chrome = WinActivate("Open")
   If $firefox <> 0 Then
	  ControlFocus("File Upload","","Edit1")
	  Sleep(500)
	  ControlSetText("File Upload","","Edit1",$CmdLine[1])
	  Sleep(500)
	  ControlClick("File Upload","","Button1")
	  Exit
   ElseIf $chrome <> 0 Then
	  ControlFocus("Open","","Edit1")
	  Sleep(500)
	  ControlSetText("Open","","Edit1",$CmdLine[1])
	  Sleep(500)
	  ControlClick("Open","","Button1")
	  Exit
   EndIf
   Sleep(1000)
   $count  = $count + 1
WEnd