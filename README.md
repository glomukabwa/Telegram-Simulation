# Telegram-Simulation

## About
This project is a UI simulation of the Telegram mobile application built using Jetpack Compose. It focuses on replicating the visual layout of the chats screen.

## Features
- Jetpack Compose UI: Built fully in Compose with Row, Column, LazyColumn, Scaffold, and Material 3 components.
- LazyColumn for List Rendering: The chat list is rendered using LazyColumn, which is the Compose equivalent of RecyclerView.
- Top App Bar: Includes a menu bar,title and search bar 
- Floating Action Buttons: Camera button, Pencil/edit button
- Profile Photos: Each chat shows a different profile image passed through sample data.
- Custom Message Layout: Chats include a profile picture, senders name, message preview, date, message counter, divider separator
- Lightweight Sample Data: Sample chats are stored in a sample list using a MessageContent data class.

## Technologies Used
- Android Studio
- Kotlin
- Jetpack Compose

## Future Improvements
- Add Search Functionality: Make the search icon open a search field and filter chats.
- Add Navigation: Navigate to a full chat screen when a chat item is clicked.
- Message Click Effects: Add ripple effect and highlight selection on press.
- Light/Dark Mode: Support themes using MaterialTheme.colorScheme.
- Real Data With Firebase: Pull chat data from Firebase Realtime Database instead of sample data.
- Add Chat Details: Show last message time, emoji indicators, read receipts, etc.
- Add Bottom Navigation: Simulate Telegram’s bottom navigation tabs (Chats, Contacts, Settings).

## Demo Pictures
- Here is a picture of the main page:<br><br> <img width="356" height="769" alt="image" src="https://github.com/user-attachments/assets/31a7ae06-b181-4085-b04c-703c1b964509" />

