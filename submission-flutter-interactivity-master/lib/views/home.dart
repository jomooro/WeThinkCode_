import 'package:flutter/material.dart';

class FunkyHomeView extends StatefulWidget {
  const FunkyHomeView({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<FunkyHomeView> createState() => _FunkyHomeViewState();
}

class _FunkyHomeViewState extends State<FunkyHomeView> {
  bool easterEggActivated = false;

  void activateEasterEgg() {
    setState(() {
      easterEggActivated = true;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Form(
          child: Column(
            children: [
              ListTile(
                leading: const Icon(Icons.account_circle, color: Colors.red),
                title: TextFormField(
                  decoration: const InputDecoration(
                    labelText: 'Username',
                    focusedBorder: OutlineInputBorder(
                      borderSide: BorderSide(color: Colors.red),
                    ),
                  ),
                ),
              ),
              ListTile(
                leading: const Icon(Icons.email, color: Colors.blue),
                title: TextFormField(
                  decoration: const InputDecoration(
                    labelText: 'Email',
                    focusedBorder: OutlineInputBorder(
                      borderSide: BorderSide(color: Colors.blue),
                    ),
                  ),
                ),
              ),
              ListTile(
                leading: const Icon(Icons.lock, color: Colors.green),
                title: TextFormField(
                  decoration: const InputDecoration(
                    labelText: 'Password',
                    focusedBorder: OutlineInputBorder(
                      borderSide: BorderSide(color: Colors.green),
                    ),
                  ),
                ),
              ),
              ListTile(
                leading: const Icon(Icons.phone, color: Colors.orange),
                title: TextFormField(
                  decoration: const InputDecoration(
                    labelText: 'Mobile number',
                    focusedBorder: OutlineInputBorder(
                      borderSide: BorderSide(color: Colors.orange),
                    ),
                  ),
                ),
              ),
              ElevatedButton(
                onPressed: easterEggActivated
                    ? () {
                        // Handle the Easter egg action here
                        // You can display a hidden message or perform any other action
                        // when the Easter egg is activated.
                        showDialog(
                          context: context,
                          builder: (context) {
                            return AlertDialog(
                              title: const Text('Thank you for registering with Make me Nice'),
                              actions: [
                                TextButton(
                                  onPressed: () {
                                    Navigator.of(context).pop();
                                  },
                                  child: const Text('OK'),
                                ),
                              ],
                            );
                          },
                        );
                      }
                    : null,
                child: const Text('Register'),
              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          // Activate the Easter egg when the user presses the FloatingActionButton
          activateEasterEgg();
        },
        child: const Icon(Icons.egg),
      ),
    );
  }
}
