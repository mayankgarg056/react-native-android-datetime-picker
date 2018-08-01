import { AppRegistry,Text,
    View,
    TouchableOpacity,
     } from 'react-native';
import React, { Component } from 'react';

export default class Index extends Component{
  
    openDatePicker=()=>{
        DateTimePickerModule.openDatePicker({
          textConfirm:"Ok", // text for confirm button deafult is "Confirm"
          textCancel:"No", // text for cancel button deafult is "Cancel"
          btnTextSize:16, // button text size
          colorCancel:"#29436d", // button cancel text color
          colorConfirm:"#29436d", // button confirm text color 
          minYear:1970, // minimum year want to show
          maxYear:2018, // maximum year want to show 
          selectDate:"2015-06-22" //yyyy-MM-dd formate 
      }).then(function(result) {
        alert(result.date)// "result":{"year":2015,"month":03,"day":23,"date":"2015-03-23"} in success after select on confirm button
      });
  
    }
    openTimePicker=()=>{
  
      DateTimePickerModule.openTimePicker({
        textConfirm:"Ok", // text for confirm button deafult is "Confirm"
        textCancel:"No", // text for cancel button deafult is "Cancel"
        btnTextSize:16, // button text size
        colorCancel:"#29436d", // button cancel text color
        colorConfirm:"#29436d", // button confirm text color 
      }).then(function(result) {
        alert(result.time)// "result":{"hour":01,"minute":56,"AM_PM":"AM","time":"01:56 AM"} in success after select on confirm button
      });
    }
    render() {
      return (
        <View style={{flex:1,backgroundColor:'white',justifyContent:'center'}}>
            <TouchableOpacity style={{padding:8,width:(window.width/2)-50,height:50,alignSelf:'center',justifyContent:'center',backgroundColor:"gray",}} onPress={this.openDatePicker} activeOpacity={0.8}>
                  <Text   style={{textAlign:'center',color:"white",fontWeight:'bold',}}>DATE PICKER</Text>
            </TouchableOpacity>
            <TouchableOpacity style={{marginTop:20,padding:8,width:(window.width/2)-50,height:50,alignSelf:'center',justifyContent:'center',backgroundColor:"gray",}} onPress={this.openTimePicker} activeOpacity={0.8}>
                  <Text   style={{textAlign:'center',color:"white",fontWeight:'bold',}}>TIME PICKER</Text>
            </TouchableOpacity>
          
        </View>
      );
    }
  }
AppRegistry.registerComponent('DateTimePicker', () => Index);
