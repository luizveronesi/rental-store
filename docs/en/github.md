# 📖 Developer Workflow Instructions

Welcome, developer! Before contributing to this project, please carefully follow the instructions below to keep
everything organized and collaborative.

---

## 📌 1️⃣ Create a `develop` Branch

After cloning your repository locally:

```bash
git checkout -b develop
```

This will create a new `develop` branch based on your current branch. Use this `develop` branch for all your work.

---

## 📌 2️⃣ Add Me as a Collaborator on GitHub

To allow me to review and collaborate on your repository:

1. Go to your repository on [GitHub](https://github.com).
2. Click on the **Settings** tab.
3. In the left sidebar, select **Collaborators and teams** or **Collaborators**.
4. Click the **Add people** button.
5. Enter my GitHub username: `luizveronesi` (replace this with my actual GitHub handle).
6. Set the appropriate permission level (usually **Write** or **Admin**).
7. Click **Add NAME to this repository**.

---

## 📌 3️⃣ Create a Pull Request (PR) from `develop` to Your `main` Branch

Once your changes are ready:

1. Push your `develop` branch to your repository:
   ```bash
   git push origin develop
   ```

2. Go to your repository on GitHub.
3. Click the **Compare & pull request** button.
4. **Important:** Make sure the base branch is your `main` branch and the compare branch is your `develop`.

   ✅ Example:
   ```
   base: main ← compare: develop
   ```

5. Add a clear title and description for your PR.
6. Click **Create pull request**.

**Note:**  
Do **not** create a PR to the original repository you forked from unless explicitly requested.

---

## ✅ Summary

- [x] Create a `develop` branch.
- [x] Add me as a collaborator.
- [x] Create a PR from your `develop` to your own `main` branch.

Thank you for collaborating properly and keeping our workflow clean and efficient! 🚀
